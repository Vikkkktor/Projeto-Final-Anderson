package com.ifpr.Projeto_Adocao.Controller;

import com.ifpr.Projeto_Adocao.Model.Gato;
import com.ifpr.Projeto_Adocao.Services.GatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/gatos")
@RestController
@CrossOrigin(origins = "*")

public class GatoController {
    @Autowired
    private GatoService gatoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarGato(@RequestBody Gato gato){
        String mensagem = gatoService.cadastroGato(gato);
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagem);

    }
    @PutMapping
    public ResponseEntity<String> atualzarGATO(@PathVariable Long id,@RequestBody Gato gato){
        String atualizado = gatoService.atualizar(id,gato);
        return ResponseEntity.ok(atualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir (@PathVariable Long id){
        gatoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
