package Animais;

public interface EmissorDeSom {
    void EmitirSons();
}

public abstract class Animal implements EmissorDeSom {
    public String nome;
    public String especie;
    public int idade;
    public String cor;

    public Animal(String nome, String especie, int idade,  String cor) {
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
        this.cor = cor;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.raca = especie;
    }
    public Int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    
    public abstract void EmitirSons();
}
