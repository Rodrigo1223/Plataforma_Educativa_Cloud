package cl.duoc.ejemplo.microservicio.repository;

import cl.duoc.ejemplo.microservicio.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}