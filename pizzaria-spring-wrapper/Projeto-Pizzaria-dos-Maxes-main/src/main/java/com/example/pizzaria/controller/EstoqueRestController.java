package com.example.pizzaria.controller;

import com.example.pizzaria.model.Estoque;
import com.example.pizzaria.service.EstoqueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueRestController {
    private final EstoqueService service;
    public EstoqueRestController(EstoqueService service) { this.service = service; }

    @GetMapping
    public List<Estoque> all() { return service.findAll(); }
}
