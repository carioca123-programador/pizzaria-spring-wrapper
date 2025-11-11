package com.example.pizzaria.service;

import com.example.pizzaria.model.Usuario;
import com.example.pizzaria.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Optional<Usuario> findById(Integer id) {
        return repository.findById(id);
    }

    public Usuario save(Usuario u) {
        return repository.save(u);
    }

    public Optional<Usuario> update(Integer id, Usuario novoUsuario) {
        return repository.findById(id).map(usuario -> {
            usuario.setNome(novoUsuario.getNome());
            usuario.setEmail(novoUsuario.getEmail());
            usuario.setSenha(novoUsuario.getSenha());
            usuario.setEndereco(novoUsuario.getEndereco());
            usuario.setTelefone(novoUsuario.getTelefone());
            usuario.setCargo(novoUsuario.getCargo());
            return repository.save(usuario);
        });
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}