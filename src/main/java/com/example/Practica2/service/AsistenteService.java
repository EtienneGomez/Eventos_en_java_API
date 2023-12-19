package com.example.Practica2.service;

import com.example.Practica2.entity.Asistente;
import com.example.Practica2.entity.Evento;
import com.example.Practica2.repository.AsistenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsistenteService {
    @Autowired
    AsistenteRepository asistenteRepository;

    public List<Asistente> listAsistentes(){
        return asistenteRepository.findAll();
    }

    public Asistente save(Asistente asistente) {
        return asistenteRepository.save(asistente);
    }
}
