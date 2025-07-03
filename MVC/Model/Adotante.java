package com.ifpr.Projeto_Adocao.Model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@DiscriminatorValue("Adotante")
@AllArgsConstructor
public class Adotante extends Pessoa {
    private String profissao;
    private boolean temoutrosanimais;

}
