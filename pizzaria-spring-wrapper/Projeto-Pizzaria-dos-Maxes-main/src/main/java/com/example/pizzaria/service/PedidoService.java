package com.example.pizzaria.service;

import com.example.pizzaria.model.Pedido;
import com.example.pizzaria.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    private final PedidoRepository repo;
    public PedidoService(PedidoRepository repo) { this.repo = repo; }

    public Pedido save(Pedido p) { return repo.save(p); }
    public Optional<Pedido> findById(Integer id) { return repo.findById(id); }
    public List<Pedido> findAll() { return repo.findAll(); }
    public void deleteById(Integer id) { repo.deleteById(id); }
}