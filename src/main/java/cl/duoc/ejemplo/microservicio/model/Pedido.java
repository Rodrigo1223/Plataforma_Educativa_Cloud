package cl.duoc.ejemplo.microservicio.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PEDIDOS")
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private Double monto;
}