package cl.duoc.ejemplo.microservicio.controllers;

import cl.duoc.ejemplo.microservicio.model.GuiaDespacho;
import cl.duoc.ejemplo.microservicio.repository.GuiaRepository;
import cl.duoc.ejemplo.microservicio.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequestMapping("/api/guias")
public class GuiaController {

    @Autowired
    private GuiaRepository guiaRepository;

    @Autowired
    private S3Service s3Service;

    @GetMapping
    public List<GuiaDespacho> getAllGuias() {
        return guiaRepository.findAll();
    }

    @PostMapping
    public GuiaDespacho createGuia(@RequestBody GuiaDespacho guia) {
        return guiaRepository.save(guia);
    }

    // Endpoint corregido con try-catch para manejar excepciones
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String fileUrl = s3Service.uploadFile(file);
            return ResponseEntity.ok("Archivo subido con éxito a: " + fileUrl);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al subir el archivo: " + e.getMessage());
        }
    }
}