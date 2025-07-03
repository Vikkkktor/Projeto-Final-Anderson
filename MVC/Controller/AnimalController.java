package com.ifpr.Projeto_Adocao.Controller;
import com.ifpr.Projeto_Adocao.Model.Animal;
import com.ifpr.Projeto_Adocao.Services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Animais")
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @PostMapping
    public ResponseEntity<String> CadastrarAnimal(Animal animal){
        String mensagem = animalService.cadastroAnimal(animal);
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagem);
    }
    @PutMapping ("/{id}")
    public ResponseEntity<String> atualizarAnimal (@PathVariable Long id,@RequestBody Animal animal){
        String atualizado = animalService.atualizar(id , animal);
        return  ResponseEntity.ok(atualizado);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAnimal (@PathVariable Long id){
        animalService.excluir(id);
        return  ResponseEntity.noContent().build();
    }

}
