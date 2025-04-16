package Animais;

public class Gato extends Animal {

    public Gato(String nome, String especie, int idade, String cor) {
        super(nome, especie, idade, cor);
    }

    @Override
    public void EmitirSons(){
        System.out.println("Miau Miau");
    }

}
