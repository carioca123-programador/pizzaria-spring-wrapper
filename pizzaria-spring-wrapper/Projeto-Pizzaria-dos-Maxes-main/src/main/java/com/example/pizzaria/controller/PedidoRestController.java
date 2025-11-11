package com.example.pizzaria.controller;

import com.example.pizzaria.model.Pedido;
import com.example.pizzaria.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoRestController {
    private final PedidoService service;
    public PedidoRestController(PedidoService service) { this.service = service; }

    @GetMapping
    public List<Pedido> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> get(@PathVariable Integer id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pedido create(@RequestBody Pedido p) { return service.save(p); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { service.deleteById(id); }
}