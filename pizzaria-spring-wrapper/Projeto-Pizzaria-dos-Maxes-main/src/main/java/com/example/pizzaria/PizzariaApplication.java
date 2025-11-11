package com.example.pizzaria;

import com.example.pizzaria.model.Usuario;
import com.example.pizzaria.model.Estoque;
import com.example.pizzaria.model.Pedido;
import com.example.pizzaria.repository.UsuarioRepository;
import com.example.pizzaria.repository.EstoqueRepository;
import com.example.pizzaria.repository.PedidoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PizzariaApplication {
    public static void main(String[] args) {
        SpringApplication.run(PizzariaApplication.class, args);
    }

    // Dados iniciais (usuários, cardápio, pedidos)
    @Bean
    CommandLineRunner initData(UsuarioRepository usuarioRepo,
                               EstoqueRepository estoqueRepo,
                               PedidoRepository pedidoRepo) {
        return args -> {
            // Usuários de exemplo
            usuarioRepo.save(new Usuario("João Oliveira", "Rua A, 123", "11999990000", "joao@gmail.com", "senha1", "Cliente"));
            usuarioRepo.save(new Usuario("Maria Souza", "Av. B, 45", "11988880000", "maria@gmail.com", "senha2", "Cliente"));
            usuarioRepo.save(new Usuario("Carlos Lima", "Rua C, 99", "11977770000", "carlos@gmail.com", "admin", "Atendente"));

            // Cardápio / estoque
            estoqueRepo.save(new Estoque(10, 25.0f, "Margherita"));
            estoqueRepo.save(new Estoque(8, 30.0f, "Calabresa"));
            estoqueRepo.save(new Estoque(5, 35.0f, "Quatro Queijos"));

            // Exemplo de pedido feito por usuário
            Usuario u = usuarioRepo.findAll().stream().findFirst().orElse(null);
            if (u != null) {
                Pedido p = new Pedido("Pizza Margherita", 25.0, "PENDENTE", u);
                pedidoRepo.save(p);
            }

            System.out.println("✅ Dados iniciais criados com sucesso!");
        };
    }
}