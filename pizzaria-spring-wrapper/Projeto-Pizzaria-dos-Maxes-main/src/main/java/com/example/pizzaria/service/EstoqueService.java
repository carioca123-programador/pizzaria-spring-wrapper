package com.example.pizzaria.service;

import com.example.pizzaria.model.Estoque;
import com.example.pizzaria.repository.EstoqueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {
    private final EstoqueRepository repo;
    public EstoqueService(EstoqueRepository repo) { this.repo = repo; }

    public Estoque save(Estoque e) { return repo.save(e); }
    public List<Estoque> findAll() { return repo.findAll(); }
    public Optional<Estoque> findById(Integer id) { return repo.findById(id); }
}
