package com.example.Practica2.controller;

import com.example.Practica2.entity.Asistente;
import com.example.Practica2.entity.Evento;
import com.example.Practica2.service.AsistenteService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "api/asistente")
public class AsistenteController {
    @Autowired
    AsistenteService asistenteService;

    @PostMapping
    public Asistente saveAsistente(@RequestBody Asistente asistente){
        return asistenteService.save(asistente);
    }
    @GetMapping
    public void downloadPdf(HttpServletResponse response) throws IOException, DocumentException {
        // Obtén la lista de eventos
        List<Asistente> asistentes = asistenteService.listAsistentes();

        // Configura la respuesta HTTP
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=events.pdf");

        // Crea el documento PDF
        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());

        // Abre el documento
        document.open();

        // Agrega los eventos al documento
        for (Asistente asistente : asistentes) {
            document.add(new Paragraph("ID: " + asistente.getIdAsistente()));
            document.add(new Paragraph("Nombre: " + asistente.getNombre() + " " + asistente.getPaterno() + " " + asistente.getMaterno()));
            document.add(new Paragraph("Email: " + asistente.getEmail()));
            document.add(new Paragraph("Fecha Registro " +  asistente.getFechaRegistro()));
            document.add(new Paragraph("Id evento: " + asistente.getEvento()));
            document.add(new Paragraph("---------------------------------------"));
        }

        // Cierra el documento
        document.close();
    }
}
