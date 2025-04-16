package Pessoas;

public class Adotante extends Pessoa{
    private String carteiraDeAdotante;


    public Adotante(String nome, String endereco, int idade, String telefone, String cpf, String carteiraDeAdotante) {
        super(nome, endereco, idade, telefone, cpf);
        this.carteiraDeAdotante = carteiraDeAdotante;
    }

    public void AdotarAnimal(){
        System.out.println("Adotando animal...");
    }

    public String getCarteiraDeAdotante() {
        return carteiraDeAdotante;
    }

    public void setCarteiraDeAdotante(String carteiraDeAdotante) {
        this.carteiraDeAdotante = carteiraDeAdotante;
    }
}
