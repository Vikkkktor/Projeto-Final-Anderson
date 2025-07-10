package com.ifpr.Projeto_Adocao.Model;
import java.util.Date;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Fallback;

// Pega as informações da classe e devolve

@NoArgsConstructor // gera um construtor sem argumentos (necessário para o JPA funcionar).
@Entity // @Entity: indica que essa classe será mapeada para uma tabela do banco de dados.
@Inheritance(strategy = InheritanceType.JOINED)
@Data// Pega as informações da classe e devolve
@DiscriminatorColumn(name = "Tipo_pessoa")
@AllArgsConstructor
public class Pessoa {
    @Id //Define o campo com PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //define que o banco vai gerar os valores automaticamente.

    private long id;
    private String nome;
    private String email;
    private String cpf;
    private String cep;
    private String cidade;
    private String estado;
    private String logradouro;
    private String complemento;
    private String telefone;
    private Date data_nasc;


}
