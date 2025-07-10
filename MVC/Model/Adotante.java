package com.ifpr.Projeto_Adocao.Model;
import com.ifpr.Projeto_Adocao.Model.Adocao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@DiscriminatorValue("Adotante")
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id_adotante") // Associa esta entidade à tabela Pessoa via ID

public class Adotante extends Pessoa {
    private String profissao;
    private boolean temoutrosanimais;
    // Um adotante pode realizar várias adoções
    @OneToMany(mappedBy = "adotante",cascade = CascadeType.ALL)
    private List<Adocao> adoceos;

}
