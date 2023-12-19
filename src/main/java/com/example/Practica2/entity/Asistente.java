package com.example.Practica2.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
@Entity
@Table(name="asistente")
public class Asistente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAsistente;

    @Column(length = 200)
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaRegistro")
    private Date fechaRegistro;

    @Column(length = 100)
    private String materno;

    @Column(length = 100)
    private String nombre;
    @Column(length = 100)
    private String paterno;

    @ManyToOne
    @JoinColumn(name = "idEvento")
    private Evento evento;
}
