package com.example.pizzaria.model;
import jakarta.persistence.*;

@Entity  
public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private String endereco;
    private String telefone;
    private String cargo; // "cliente" ou "atendente"
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // ✅ identificador obrigatório

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha, String endereco, String telefone, String cargo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cargo = cargo;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    // Método para verificar login
    public boolean autenticar(String email, String senha) {
        return this.email.equalsIgnoreCase(email) && this.senha.equals(senha);
    }

    // Métodos de acesso conforme o cargo
    public void mostrarAcessos() {
        System.out.println("Acessos do usuário " + nome + ":");
        if (cargo.equalsIgnoreCase("cliente")) {
            System.out.println("- Acessar cardápio");
            System.out.println("- Fazer pedido");
            System.out.println("- Confirmar pagamento");
        } else if (cargo.equalsIgnoreCase("atendente")) {
            System.out.println("- Acessar todos os pedidos");
            System.out.println("- Gerenciar cardápio");
        } else {
            System.out.println("- Cargo desconhecido. Nenhum acesso definido.");
        }
    }

    @Override
    public String toString() {
        return "\nUsuário: " + nome +
               "\nEmail: " + email +
               "\nTelefone: " + telefone +
               "\nEndereço: " + endereco +
               "\nCargo: " + cargo;
    }
}