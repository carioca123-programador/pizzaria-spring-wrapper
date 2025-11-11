package com.example.pizzaria.model;

import jakarta.persistence.*;
import com.example.pizzaria.model.Usuario;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descricao;
    private double valor;
    private String status; // Ex: "Em preparo", "Entregue", etc.

   @ManyToOne
@JoinColumn(name = "usuario_id")

    private Usuario usuario; // Agora cada pedido pertence a um usuário

    public Pedido() {}

    public Pedido(String descricao, double valor, String status, Usuario usuario) {
        this.descricao = descricao;
        this.valor = valor;
        this.status = status;
        this.usuario = usuario;
    }

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}