package com.ifpr.Projeto_Adocao.Model;
import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("Funcionário")
@AllArgsConstructor

@PrimaryKeyJoinColumn(name = "id_funcionario")
public class Funcionario extends Pessoa {
    private String cargo;
    private Double salario;
}
