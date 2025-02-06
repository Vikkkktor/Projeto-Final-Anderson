package Animais;

import java.util.Scanner;

public class Passaro extends Animal {
    Scanner scanner = new Scanner(System.in);
    public Boolean podeVoar;
    public Boolean podeFalar;

    public Passaro(String nome, String especie, int idade, String cor, Boolean podeVoar, Boolean podeFalar) {
        super(nome, especie, idade, cor);
        this.podeVoar = podeVoar;
        this.podeFalar = podeFalar;
    }


    @Override
    public void EmitirSons(){
        if(podeFalar){
            String imitacao = scanner.nextLine();
            System.out.println(imitacao);
        }
        else{
            System.out.println("PRU PRU");
        }
    }
    public void Voar(){
        if(getPodeVoar()){
            System.out.println("voando...");
        }else{
            System.out.println("Esse passáro está machucado!");
        }
    }
    
    public Boolean getPodeVoar() {
        return podeVoar;
    }
    public void setPodeVoar(Boolean podeVoar) {
        this.podeVoar = podeVoar;
    }
    public Boolean getPodeFalar() {
        return podeFalar;
    }
    public void setPodeFalar(Boolean podeFalar) {
        this.podeFalar = podeFalar;
    }
}
