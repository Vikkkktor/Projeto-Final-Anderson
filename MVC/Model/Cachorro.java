package Animais;

public class Cachorro extends Animal {
    private boolean eTreinado;

    // Construtores
    public Cachorro(String nome, int idade, String raca, boolean eTreinado) {
        super(nome, idade, raca);
        this.eTreinado = eTreinado;
    }

    // Getters and setters
    public boolean isETreinado() {
        return eTreinado;
    }

    public void setETreinado(boolean eTreinado) {
        this.eTreinado = eTreinado;
    }
}
