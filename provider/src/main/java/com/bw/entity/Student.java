package com.bw.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "student")
public class Student implements Serializable {
    private static final long serialVersionUID = 6500845784367157212L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sid;
    private String sname;
    private String url;
    private String hobby;
    private String age;
    private String sex;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
//一对一
    @OneToOne(targetEntity = Dept.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "did",referencedColumnName = "did",insertable = true,updatable = true,nullable = true)
    @NotFound(action = NotFoundAction.IGNORE)
    private Dept dept;
//多对一
    @ManyToOne(targetEntity = Levels.class,cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    @JoinColumn(name = "lid",referencedColumnName = "lid",insertable = true,updatable = true,nullable = true,
            foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    @NotFound(action = NotFoundAction.IGNORE)
    private Levels levels;
//一对多
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "sid",referencedColumnName = "sid")
    @NotFound(action = NotFoundAction.IGNORE)
    private List<House> house;
//多对多
    @ManyToMany(cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    @JoinTable(name = "sp",
    joinColumns = {@JoinColumn(name = "sid",referencedColumnName = "sid",foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))},
    inverseJoinColumns = {@JoinColumn(name = "pid",referencedColumnName = "pid",foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))},
    uniqueConstraints = {@UniqueConstraint(name = "unit",columnNames = {"sid","pid"})})
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Sport> sport;








}
