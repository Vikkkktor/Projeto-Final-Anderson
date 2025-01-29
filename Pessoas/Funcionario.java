package Pessoas;

public class Funcionario extends Pessoa{

    public Funcionario(String nome, String endereco, int idade, String telefone, String cpf) {
        super(nome, endereco, idade, telefone, cpf);
    }

    public void ResgatarAnimal(){
        System.out.println("Resgatando animal...");
    }

    public void RegistrarAnimal(){
        System.out.println("Registrando animal...");
    }


}
