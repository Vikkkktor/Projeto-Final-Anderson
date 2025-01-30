package Animais;

// Classe Abstrata Animal
public abstract class Animal {
    public String nome;
    public String raca;
    public int idade;
    public String porte;
    public String cor;

    // Construtor da Classe Animal
    public Animal(String nome, String raca, int idade, String porte, String cor) {
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.porte = porte;
        this.cor = cor;
    }
    // Gets e Sets
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getRaca() {
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }
    public Int getIdade() {
        return idade;
    }
    public void setIdade(Int idade) {
        this.idade = idade;
    }
    public String getPorte() {
        return porte;
    }
    public void setPorte(String porte) {
        this.porte = porte;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    
    public abstract void EmitirSons();
}
