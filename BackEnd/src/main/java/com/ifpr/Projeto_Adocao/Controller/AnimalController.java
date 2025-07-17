package com.ifpr.Projeto_Adocao.Controller;
import com.ifpr.Projeto_Adocao.Model.Animal;
import com.ifpr.Projeto_Adocao.Services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Animais")
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @PostMapping
    // O Animal completo (incluindo caminhoImagem como String) virá no corpo da requisição JSON
    public ResponseEntity<String> CadastrarAnimal(@RequestBody Animal animal){
        String mensagem = animalService.cadastroAnimal(animal); // O serviço agora só recebe o Animal
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagem);
    }

    @PutMapping ("/{id}")
    // O Animal completo (incluindo caminhoImagem como String) virá no corpo da requisição JSON
    public ResponseEntity<String> atualizarAnimal (@PathVariable Long id, @RequestBody Animal animal){
        String atualizado = animalService.atualizar(id , animal); // O serviço agora só recebe o Animal
        return  ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAnimal (@PathVariable Long id){
        animalService.excluir(id);
        return  ResponseEntity.noContent().build();
    }
    // Listar todos os animais
    @GetMapping
    public ResponseEntity<List<Animal>> listarAnimais(){
        List<Animal> animais = animalService.listarAnimais(); // Chama um novo metodo no serviço
        return ResponseEntity.ok(animais);
    }

    // Buscar animal por ID
    @GetMapping("/{id}")
    public ResponseEntity<Animal> buscarAnimalPorId(@PathVariable Long id){
        Animal animal = animalService.buscarAnimalPorId(id); // Chama um novo metodo no serviço
        if (animal != null) {
            return ResponseEntity.ok(animal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}