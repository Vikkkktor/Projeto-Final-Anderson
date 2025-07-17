package com.ifpr.Projeto_Adocao.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.List; // Para a relação OneToMany com Adocao

@Entity
@Table(name = "Adotante") // Mapeia para a tabela Adotante
@Data // Gera getters, setters, equals, hashCode e toString (Lombok)
@NoArgsConstructor // Gera construtor sem argumentos (Lombok)
@AllArgsConstructor // Gera construtor com todos os argumentos (Lombok)
public class Adotante {

    @Id // Define o campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o banco vai gerar os valores automaticamente
    @Column(name = "ID_Adotante") // Mapeia para a coluna ID_Adotante no banco de dados
    private Long id; //


    @Column(name = "Login", nullable = false, unique = true, length = 50)
    private String login; //

    @Column(name = "Nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "Sobrenome", nullable = false, length = 50)
    private String sobrenome;

    @Column(name = "Email", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "CEP", nullable = false, length = 9)
    private String cep;

    @Column(name = "Cidade", nullable = false, length = 50)
    private String cidade;

    @Column(name = "Estado", nullable = false, length = 2)
    private String estado;

    @Column(name = "Logradouro", nullable = false, length = 100)
    private String logradouro;

    @Column(name = "Complemento", length = 50)
    private String complemento;

    @Column(name = "date_nas", nullable = false)
    @Temporal(TemporalType.DATE) //
    private Date date_nas;

    @Column(name = "Senha", nullable = false, length = 255)
    private String senha; //
    @Column(name = "Telefone", nullable = false, length = 16)
    private String telefone;

    @Column(name = "CPF", nullable = false, unique = true, length = 14)
    private String cpf;

    @OneToMany(mappedBy = "adotante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Adocao> adocoes;
}