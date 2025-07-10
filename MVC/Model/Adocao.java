package com.ifpr.Projeto_Adocao.Model;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
@Entity
@Data

public class Adocao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private Date dataAdocao;
    // Muitos registros de adoção podem estar ligados ao mesmo adotante
    @ManyToMany
    @JoinColumn(name = "Id_adotante") // nome da coluna FK no banco
    private Adotante adotante;
    // Muitos registros de adoção podem estar ligados ao mesmo animal
    @ManyToMany
    @JoinColumn(name = "id_animal") // nome da coluna FK no banco
    private Animal animal;


}
