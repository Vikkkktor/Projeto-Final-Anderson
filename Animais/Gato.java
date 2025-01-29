package Animais;

public class Gato extends Animal {
    public String tipoDePelo;

    public Gato(String nome, String raca, int idade, String porte, String cor, String tipoDePelo) {
        super(nome, raca, idade, porte, cor);
        this.tipoDePelo = tipoDePelo;
    }

    @Override
    public void EmitirSons(){
        System.out.println("Miau Miau");
    }
}
