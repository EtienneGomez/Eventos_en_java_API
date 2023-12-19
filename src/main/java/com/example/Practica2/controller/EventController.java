package com.example.Practica2.controller;

import com.example.Practica2.entity.Evento;
import com.example.Practica2.service.EventoService;
import jakarta.servlet.http.HttpServletResponse;
import jdk.jfr.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "api/evento")
public class EventController {
    @Autowired
    private EventoService eventoService;

    @PostMapping
    public Evento saveComentario(@RequestBody Evento evento){
        return eventoService.save(evento);
    }
    @GetMapping
    public void downloadPdf(HttpServletResponse response) throws IOException, DocumentException {
        // Obtén la lista de eventos
        List<Evento> eventos = eventoService.listEvent();

        // Configura la respuesta HTTP
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=events.pdf");

        // Crea el documento PDF
        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());

        // Abre el documento
        document.open();

        // Agrega los eventos al documento
        for (Evento evento : eventos) {
            document.add(new Paragraph("ID: " + evento.getIdEvento()));
            document.add(new Paragraph("Nombre: " + evento.getNombreEvento()));
            document.add(new Paragraph("Descripcion: " + evento.getDescripcionEvento()));
            document.add(new Paragraph("Fecha Creacion " +  evento.getFechaCreacion()));
            document.add(new Paragraph("---------------------------------------"));
        }

        // Cierra el documento
        document.close();
    }
}
