package cl.duoc.ejemplo.microservicio.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CURSOS")
@Data
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String instructor;
    private int duracion;
    private double costo;
}