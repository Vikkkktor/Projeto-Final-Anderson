package com.ifpr.Projeto_Adocao.Controller;
import com.ifpr.Projeto_Adocao.Model.Adotante;
import com.ifpr.Projeto_Adocao.Services.AdotanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/Adotantes")
@RestController
@CrossOrigin(origins = "*")
public class AdotanteController {

    @Autowired
    private AdotanteService adotanteService;
    // Cadastra
    @PostMapping
    public ResponseEntity<String> cadastrarAdotante(@RequestBody Adotante adotante){
        String mensagem =  adotanteService.cadastrarAdotante(adotante);
        return  ResponseEntity.status(HttpStatus.CREATED).body(mensagem);
    }
    // Excluí
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir (@PathVariable Long id){
        adotanteService.excluir(id);
        return ResponseEntity.noContent().build();
    }
    //Atualiza
    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar (@PathVariable Long id, @RequestBody Adotante adotante){
       String atualizado =  adotanteService.atualizar(id,adotante);
        return ResponseEntity.ok(atualizado);
    }
}
