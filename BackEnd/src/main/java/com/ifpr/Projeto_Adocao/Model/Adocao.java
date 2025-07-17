package com.ifpr.Projeto_Adocao.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date; // Para Data_Adocao

@Entity
@Table(name = "Adocao") // Mapeia para a tabela Adocao no banco de dados
@Data // Gera getters, setters, equals, hashCode e toString (Lombok)
@NoArgsConstructor // Gera construtor sem argumentos (Lombok)
@AllArgsConstructor // Gera construtor com todos os argumentos (Lombok)
public class Adocao {

    @Id // Define o campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o banco vai gerar os valores automaticamente
    @Column(name = "ID_Adocao") // Mapeia para a coluna ID_Adocao no banco de dados
    private Long id; //

    @Column(name = "Data_Adocao", nullable = false)
    @Temporal(TemporalType.DATE) // Define que é apenas a data (sem informações de tempo)
    private Date dataAdocao;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_animal", nullable = false)
    private Animal animal; // Referência à entidade Animal associada


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_adotante", nullable = false)
    private Adotante adotante; // Referência à entidade Adotante associada
}
