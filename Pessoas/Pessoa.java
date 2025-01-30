package Pessoas;

// Classe Pessoa da Casa de Adoção
public abstract class Pessoa {
    public String nome;
    private String endereco;
    private int idade;
    private String telefone;
    private String cpf;

    // Construtor da Classe Pessoa
    public Pessoa(String nome, String endereco, int idade, String telefone, String cpf) {
        this.nome = nome;
        this.endereco = endereco;
        this.idade = idade;
        this.telefone = telefone;
        this.cpf = cpf;
    }
    // Gets e Sets
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public Int getIdade() {
        return idade;
    }
    public void setIdade(Int idade) {
        this.idade = idade
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
