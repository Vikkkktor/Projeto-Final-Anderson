package Animais;

public class Animal {
    private int idAnimal;
    private String nome;
    private int idade;
    private String raca;
    private boolean adotado;
    private Especie especie;
    private Boolean podeVoar;   // Apenas para pássaros
    private Boolean podeFalar;  // Apenas para pássaros
    private Boolean eTreinado;  // Apenas para cachorros

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public boolean isAdotado() {
        return adotado;
    }

    public void setAdotado(boolean adotado) {
        this.adotado = adotado;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
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

    public Boolean getETreinado() {
        return eTreinado;
    }

    public void setETreinado(Boolean eTreinado) {
        this.eTreinado = eTreinado;
    }
}
