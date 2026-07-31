package cl.duoc.ejemplo.microservicio.controllers;
import cl.duoc.ejemplo.microservicio.model.Curso;
import cl.duoc.ejemplo.microservicio.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    @Autowired
    private CursoService service;

    @GetMapping
    public List<Curso> listar() { return service.listarCursos(); }

    @PostMapping
    public Curso guardar(@RequestBody Curso curso) { return service.guardarCurso(curso); }
}