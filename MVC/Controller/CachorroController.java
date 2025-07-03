package com.ifpr.Projeto_Adocao.Controller;

import com.ifpr.Projeto_Adocao.Model.Cachorro;
import com.ifpr.Projeto_Adocao.Services.CachorroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cachorros")
@RestController
public class CachorroController {
    @Autowired
    private CachorroService cachorroService;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> CadastrarCachorro(@RequestBody Cachorro cachorro){
       String mensagem = cachorroService.CadastroCachorro(cachorro);
       return  ResponseEntity.status(HttpStatus.CREATED).body(mensagem);
    }
    @PutMapping
    public ResponseEntity<String> atualizar (@PathVariable Long id, Cachorro cachorro){
        String atualizado = cachorroService.atualizar(id,cachorro);
        return ResponseEntity.ok(atualizado);
    }
    @DeleteMapping
    public ResponseEntity<Void> excluir (@PathVariable Long id){
        cachorroService.excluir(id);
        return  ResponseEntity.noContent().build();

    }
}
