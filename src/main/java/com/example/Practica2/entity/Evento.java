package com.example.Practica2.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
@Entity
@Table(name="evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvento;

    @Column(length = 250)
    private String descripcionEvento;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaCreacion")
    private Date fechaCreacion;

    @Column(length = 250)
    private String nombreEvento;
}
