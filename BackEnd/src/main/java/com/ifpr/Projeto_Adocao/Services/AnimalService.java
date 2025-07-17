package com.ifpr.Projeto_Adocao.Services;
import com.ifpr.Projeto_Adocao.Model.Animal;
import com.ifpr.Projeto_Adocao.Util.Util;
import com.ifpr.Projeto_Adocao.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class AnimalService {

    @Autowired private AnimalRepository animalRepository;

    public String cadastroAnimal(Animal animal){
        Animal a = animalRepository.existsbyNome(animal.getNome());
        if (a != null && a.getNome().equals(animal.getNome())) {
            return "Já existe um animal com esse nome!";
        }
        // O campo 'caminhoImagem' já deve vir preenchido no objeto 'animal'
        animalRepository.save(animal);
        return "O Cadastro do Animal foi realizado com sucesso!";
    }

    public String atualizar(Long id , Animal novosdados){
        Animal animal  = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado!"));

        // Lógica de validação de nome (mantida e corrigida)
        if (!Util.validarNome(novosdados.getNome())) { // Se o nome for INVÁLIDO
            throw new IllegalArgumentException("Nome inválido");
        }

        // O campo 'caminhoImagem' será atualizado diretamente do 'novosdados'
        animal.setRaca(novosdados.getRaca());
//        animal.setAdotado(novosdados .isAdotado());
        animal.setDescricao(novosdados.getDescricao());
//        animal.setCaminhoImagem(novosdados.getCaminhoImagem()); // Atualiza o caminho da imagem

        animalRepository.save(animal);
        return  "Os dados foram atualiados com sucesso!";
    }

    public void excluir(Long id){
        if (!animalRepository.existsById(id)){
            throw new RuntimeException("Animal não encontrado");
        }
        animalRepository.deleteById(id);
    }
    //Listar todos os animais
    public List<Animal> listarAnimais() {

        return animalRepository.findAll();
    }

    // Buscar animal por ID
    public Animal buscarAnimalPorId(Long id) {

        return animalRepository.findById(id).orElse(null);
    }
}