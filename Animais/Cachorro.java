package Animais;

public class Cachorro extends Animal {

    public Boolean eTreinado;

    public Cachorro(String nome, String especie, int idade, String cor, Boolean eTreinado) {
        super(nome, especie, idade, cor);
        this.eTreinado = eTreinado;
    }

    @Override
    public void EmitirSons(){
        System.out.println("AuAuAuAu");
    }
    public void FazerTruques(){
        if(getETreinado()){
            System.out.println("Fazendo truques...");
        }else{
            System.out.println("Esse Cachorro não é adestrado!");
        }
    }

    public Boolean getETreinado() {
        return eTreinado;
    }
    public void setETreinado(Boolean eTreinado) {
        this.eTreinado = eTreinado;
    }
}
