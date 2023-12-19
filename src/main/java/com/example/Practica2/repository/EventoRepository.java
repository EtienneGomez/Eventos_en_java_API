package com.example.Practica2.repository;

import com.example.Practica2.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
}
