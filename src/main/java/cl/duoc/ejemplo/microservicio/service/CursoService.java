package cl.duoc.ejemplo.microservicio.service;
import cl.duoc.ejemplo.microservicio.model.Curso;
import cl.duoc.ejemplo.microservicio.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CursoService {
    @Autowired
    private CursoRepository repository;

    public List<Curso> listarCursos() { return repository.findAll(); }
    public Curso guardarCurso(Curso curso) { return repository.save(curso); }
}