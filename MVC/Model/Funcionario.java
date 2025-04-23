package Pessoas;

public class Funcionario extends Pessoa {
    private String matricula;

    // Construtores
    public Funcionario(String nome, String endereco, int idade, String telefone, String cpf, String matricula) {
        super(nome, endereco, idade, telefone, cpf);
        this.matricula = matricula;
    }

    // Getters and setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
