package cl.duoc.ejemplo.microservicio.controllers;

import cl.duoc.ejemplo.microservicio.model.Pedido;
import cl.duoc.ejemplo.microservicio.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos") // Ruta base: http://localhost:8080/api/pedidos
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    // 1. Obtener todos los pedidos
    @GetMapping
    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    // 2. Crear un nuevo pedido
    @PostMapping
    public Pedido createPedido(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    // 3. Obtener un pedido por ID
    @GetMapping("/{id}")
    public Pedido getPedidoById(@PathVariable Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con id: " + id));
    }
}