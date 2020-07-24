package com.bw.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "sport")
public class Sport implements Serializable {
    private static final long serialVersionUID = -9062072811826169429L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;
    private String pname;
}
