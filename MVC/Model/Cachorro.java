package com.ifpr.Projeto_Adocao.Model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("Cachorro")
@AllArgsConstructor

@PrimaryKeyJoinColumn(name = "id_cachorro")
public class Cachorro extends Animal{


}
