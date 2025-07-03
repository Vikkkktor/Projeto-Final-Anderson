package com.ifpr.Projeto_Adocao.Services;
import com.ifpr.Projeto_Adocao.Model.Animal;
import com.ifpr.Projeto_Adocao.Util.Util;
import com.ifpr.Projeto_Adocao.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    @Autowired private AnimalRepository animalRepository;

    public String cadastroAnimal(Animal animal){
        Animal a=animalRepository.existsbyNome(animal.getNome());
        if (a.getNome().equals(animal.getNome())){
            return "Já existe um animal com esse nome!";
        }
        animalRepository.save(animal);
        return "O Cadastro do Animal foi realizado com sucesso!";
    }
    public String atualizar(Long id , Animal novosdados){
        Animal animal  = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado!"));
        if (Util.validarNome(novosdados .getNome())){
            throw new IllegalArgumentException("Nome inválido");
        }
        animal.setRaca(novosdados.getRaca());
        animal.setData_nasc(novosdados .getData_nasc());
        animal.setAdotado(novosdados .isAdotado());
        animal.setDescricao(novosdados.getDescricao());
        animalRepository.save(animal);
        return  "Os dados foram atualiados com sucesso!";
    }
    public void excluir(Long id){
        if (!animalRepository.existsById(id)){
            throw new RuntimeException("Animal não encontrado");
        }
        animalRepository.deleteById(id);
    }

}
