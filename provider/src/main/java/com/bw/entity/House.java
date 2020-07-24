package com.bw.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "house")
public class House implements Serializable {
    private static final long serialVersionUID = 863780256430929287L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hid;
    private String hname;
    private String address;
    private String harea;
}
