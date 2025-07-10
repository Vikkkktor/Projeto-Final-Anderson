package com.ifpr.Projeto_Adocao.Model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Gato")

@PrimaryKeyJoinColumn(name = "id_gato")
public class Gato extends Animal{

}
