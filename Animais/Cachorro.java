package Animais;

public class Cachorro extends Animal {
    public Boolean eTreinado;

    public Cachorro(String nome, String raca, int idade, String porte, String cor, Boolean eTreinado) {
        super(nome, raca, idade, porte, cor);
        this.eTreinado = eTreinado;
    }

    @Override
    public void EmitirSons(){
        System.out.println("AuAuAuAu");
    }
    public Boolean getETreinado() {
        return eTreinado;
    }
    public void setETreinado(Boolean eTreinado) {
        this.eTreinado = eTreinado;
    }
}
