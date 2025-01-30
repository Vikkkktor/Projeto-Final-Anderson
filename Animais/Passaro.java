package Animais;

import java.util.Scanner;

public class Passaro extends Animal {
    Scanner scanner = new Scanner(System.in);
    public Boolean eDomestico;
    public Boolean podeVoar;
    public Boolean podeFalar;

    public Passaro(String nome, String raca, int idade, String porte, String cor, Boolean eDomestico, Boolean podeVoar, Boolean podeFalar) {
        super(nome, raca, idade, porte, cor);
        this.eDomestico = eDomestico;
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
    public Boolean getEDomestico() {
        return eDomestico;
    }
    public void setEDomestico(Boolean eDomestico) {
        this.eDomestico = eDomestico;
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
