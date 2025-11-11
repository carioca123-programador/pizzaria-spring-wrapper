package com.example.pizzaria.model;

import jakarta.persistence.*;

@Entity
public class Estoque {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantidade;
    private Float valor;
    private String nomeProduto;

    public Estoque() {}
    public Estoque(Integer quantidade, Float valor, String nomeProduto) {
        this.quantidade = quantidade;
        this.valor = valor;
        this.nomeProduto = nomeProduto;
    }

    public Integer getId() { return id; }
    public Integer getQuantidade() { return quantidade; }
    public Float getValor() { return valor; }
    public String getNomeProduto() { return nomeProduto; }

    public void setId(Integer id) { this.id = id; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }
    public void setValor(Float valor) { this.valor = valor; }
    public void setNomeProduto(String nomeProduto) { this.nomeProduto = nomeProduto; }
}
