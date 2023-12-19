package com.example.Practica2.service;

import com.example.Practica2.entity.Evento;
import com.example.Practica2.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {
    @Autowired
    EventoRepository eventoRepository;

    public List<Evento> listEvent(){
        return eventoRepository.findAll();
    }

    public Evento save(Evento evento) {
        return eventoRepository.save(evento);
    }
}
