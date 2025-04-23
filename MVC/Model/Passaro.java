package Animais;

public class Passaro extends Animal {
    private boolean podeVoar;
    private boolean podeFalar;

    // Construtores
    public Passaro(String nome, int idade, String raca, boolean podeVoar, boolean podeFalar) {
        super(nome, idade, raca);
        this.podeVoar = podeVoar;
        this.podeFalar = podeFalar;
    }

    // Getters and setters
    public boolean isPodeVoar() {
        return podeVoar;
    }

    public void setPodeVoar(boolean podeVoar) {
        this.podeVoar = podeVoar;
    }

    public boolean isPodeFalar() {
        return podeFalar;
    }

    public void setPodeFalar(boolean podeFalar) {
        this.podeFalar = podeFalar;
    }
}
