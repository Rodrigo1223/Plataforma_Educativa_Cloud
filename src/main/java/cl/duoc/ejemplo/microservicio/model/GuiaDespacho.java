package cl.duoc.ejemplo.microservicio.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "GUIAS_DESPACHO")
@Data
public class GuiaDespacho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroGuia;
    private LocalDate fechaEmision;
    private String transportista;
    private String s3Url; // Requisito para la integración con S3

    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
}