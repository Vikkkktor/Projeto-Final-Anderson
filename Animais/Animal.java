package Animais;

public abstract class Animal {
    public String nome;
    public String raca;
    public int idade;
    public String porte;
    public String cor;

    public Animal(String nome, String raca, int idade, String porte, String cor) {
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.porte = porte;
        this.cor = cor;
    }

    public abstract void EmitirSons();
}
