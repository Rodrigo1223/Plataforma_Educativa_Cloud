package cl.duoc.ejemplo.microservicio.repository;
import cl.duoc.ejemplo.microservicio.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}