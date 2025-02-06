package Animais;

public abstract class Animal {
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
        return raca;
    }
    public void setEspecie(String raca) {
        this.raca = raca;
    }
    public Int getIdade() {
        return idade;
    }
    public void setIdade(Int idade) {
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
