package Pessoas;

public class Pessoa {
    private int idPessoa;
    private String nome;
    private String cep;
    private String estado;
    private String logradouro;
    private String complemento;
    private int idade;
    private String senha;
    private String telefone;
    private String cpf;

    // Construtores
    public Pessoa(String nome, String endereco, int idade, String telefone, String cpf) {
        this.nome = nome;
        this.endereco = endereco;
        this.idade = idade;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    // Getters and setters
    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
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
