package Pessoas;

public class Pessoa {
    private int idPessoa;
    private String nome;
    private String endereco;
    private int idade;
    private String telefone;
    private String cpf;
    private Funcao funcao;

    // Apenas para Adotantes
    private String carteiraAdotante;

    // Getters e Setters
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

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public String getCarteiraAdotante() {
        return carteiraAdotante;
    }

    public void setCarteiraAdotante(String carteiraAdotante) {
        this.carteiraAdotante = carteiraAdotante;
    }
}
