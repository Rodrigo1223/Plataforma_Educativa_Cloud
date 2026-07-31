package cl.duoc.ejemplo.microservicio.repository;

import cl.duoc.ejemplo.microservicio.model.GuiaDespacho;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GuiaRepository extends JpaRepository<GuiaDespacho, Long> {
    // Requisito de la pauta: Consultar por transportista y fecha
    List<GuiaDespacho> findByTransportista(String transportista);
}