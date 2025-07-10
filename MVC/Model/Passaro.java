package com.ifpr.Projeto_Adocao.Model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Passaro")
@PrimaryKeyJoinColumn(name = "id_passaro")
public class Passaro extends Animal{
    private boolean falar;
    private boolean voar;
}
