package com.bw.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "dept")
public class Dept implements Serializable {
    private static final long serialVersionUID = -7070276999154563916L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer did;
    private String dname;
    private String types;
}
