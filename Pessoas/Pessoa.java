package Pessoas;

public abstract class Pessoa {
    public String nome;
    private String endereco;
    private int idade;
    private String telefone;
    private String cpf;

    public Pessoa(String nome, String endereco, int idade, String telefone, String cpf) {
        this.nome = nome;
        this.endereco = endereco;
        this.idade = idade;
        this.telefone = telefone;
        this.cpf = cpf;
    }
}
