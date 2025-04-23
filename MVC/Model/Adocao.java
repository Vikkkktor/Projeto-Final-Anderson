package Sistema;

import Animais.Animal;
import Pessoas.Adotante;

import java.util.Date;

public class Adocao {
    private int idAdocao;
    private Animal animal;
    private Adotante adotante;
    private Date dataAdocao;

    // Construtores
    public Adocao(Animal animal, Adotante adotante, Date dataAdocao) {
        this.animal = animal;
        this.adotante = adotante;
        this.dataAdocao = dataAdocao;
    }

    // Getters and setters
    public int getIdAdocao() {
        return idAdocao;
    }

    public void setIdAdocao(int idAdocao) {
        this.idAdocao = idAdocao;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Adotante getAdotante() {
        return adotante;
    }

    public void setAdotante(Adotante adotante) {
        this.adotante = adotante;
    }

    public Date getDataAdocao() {
        return dataAdocao;
    }

    public void setDataAdocao(Date dataAdocao) {
        this.dataAdocao = dataAdocao;
    }
}
