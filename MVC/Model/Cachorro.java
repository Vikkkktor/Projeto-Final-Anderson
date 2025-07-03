package com.ifpr.Projeto_Adocao.Model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("Cachorro")
@AllArgsConstructor
public class Cachorro extends Animal{

}
