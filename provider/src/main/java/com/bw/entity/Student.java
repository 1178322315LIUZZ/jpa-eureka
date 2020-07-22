package com.bw.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
    private Date data;
}
