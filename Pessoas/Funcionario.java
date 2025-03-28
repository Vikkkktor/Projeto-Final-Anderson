package Pessoas;

public interface FuncoesFuncionario {
    void ResgatarAnimal();
    void RegistrarAnimal();
}

public class Funcionario extends Pessoa implements FuncoesFuncionario{

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
