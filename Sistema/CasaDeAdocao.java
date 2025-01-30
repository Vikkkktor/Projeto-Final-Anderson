package Sistema;

import Animais.Animal;
import Pessoas.Adotante;

import java.util.ArrayList;
import java.util.List;

public class CasaDeAdocao {
  private List<Animal> animaisDisponiveis;
  private List<Adotante> adotantes;

  public CasaDeAdocao() {
    this.animaisDisponiveis = new ArrayList<>();
    this.adotantes = new ArrayList<>();
  }

  public List<Animal> getAnimaisDisponiveis() {
    return animaisDisponiveis;
  }
  public void setAnimaisDisponiveis(List<Animal> animaisDisponiveis) {
    this.animaisDisponiveis = animaisDisponiveis;
  }
  public List<Adotante> getAdotantes() {
    return adotantes;
  }
  public void setAdotantes(List<Adotante> adotantes) {
    this.adotantes = adotantes;
  }
}
