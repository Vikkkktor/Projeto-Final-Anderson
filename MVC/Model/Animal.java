package com.ifpr.Projeto_Adocao.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@DiscriminatorColumn(name = "Tipo_Animal",discriminatorType = DiscriminatorType.STRING)
@AllArgsConstructor
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String nome;
    private String raca;
    private Date data_nasc;
    private boolean adotado;
    private String descricao;
}
