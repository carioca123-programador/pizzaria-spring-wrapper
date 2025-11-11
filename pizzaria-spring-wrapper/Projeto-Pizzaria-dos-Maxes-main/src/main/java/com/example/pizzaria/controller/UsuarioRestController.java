package com.example.pizzaria.controller;

import com.example.pizzaria.model.Usuario;
import com.example.pizzaria.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioRestController {

    private final UsuarioService service;

    public UsuarioRestController(UsuarioService service) {
        this.service = service;
    }

    // GET /api/usuarios → lista todos os usuários
    @GetMapping
    public List<Usuario> all() {
        return service.findAll();
    }

    // GET /api/usuarios/{id} → busca usuário por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> get(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/usuarios → cria um novo usuário
    @PostMapping
    public Usuario create(@RequestBody Usuario u) {
        return service.save(u);
    }

    // PUT /api/usuarios/{id} → atualiza um usuário existente
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody Usuario novoUsuario) {
        return service.update(id, novoUsuario)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/usuarios/{id} → exclui um usuário pelo ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteById(id);
    }
}