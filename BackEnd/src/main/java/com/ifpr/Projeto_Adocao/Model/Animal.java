package com.ifpr.Projeto_Adocao.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@DiscriminatorColumn(name = "Tipo_Animal",discriminatorType = DiscriminatorType.STRING)
@AllArgsConstructor
public class Animal {

    @Id // Define o campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o banco vai gerar os valores automaticamente
    @Column(name = "ID_Animal") // Mapeia para a coluna ID_Animal no banco de dados
    private Long id;

    @Column(name = "Nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "CaminhoImg", length = 255)
    private String caminhoImg;

    @Column(name = "Descricao", length = 200)
    private String descricao;

    @Column(name = "idade")

    private String idade; // Mapeia para ENUM('Filhote', 'Jovem', 'Adulto', 'Idoso')

    @Column(name = "sexo", length = 1)
    private String sexo; // Mapeia para CHAR(1)

    @Column(name = "porte")
    // Usando String para ENUM('Pequeno', 'Médio', 'Grande')
    private String porte;

    @Column(name = "especie")
    // Usando String para ENUM('Passaro', 'Cachorro', 'Gato')
    private String especie;

    @Column(name = "castrado", nullable = false)
    private Boolean castrado = false; // Valor padrão false

    @Column(name = "Raca", nullable = false, length = 30)
    private String raca;

    @Column(name = "data_nas")
    @Temporal(TemporalType.DATE) // Define que é apenas a data (sem informações de tempo)
    private Date data_nas;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Adocao> adocoes;
}
