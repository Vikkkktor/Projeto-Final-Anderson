package Pessoas;

public class Adotante extends Pessoa {
    private String carteiraAdotante;

    // Construtores
    public Adotante(String nome, String endereco, int idade, String telefone, String cpf, String carteiraAdotante) {
        super(nome, endereco, idade, telefone, cpf);
        this.carteiraAdotante = carteiraAdotante;
    }

    // Getters and setters
    public String getCarteiraAdotante() {
        return carteiraAdotante;
    }

    public void setCarteiraAdotante(String carteiraAdotante) {
        this.carteiraAdotante = carteiraAdotante;
    }
}
