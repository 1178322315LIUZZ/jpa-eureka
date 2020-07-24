package com.bw.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "level")
public class Levels implements Serializable {
    private static final long serialVersionUID = 8158970395484982591L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lid;
    private String lname;
}
