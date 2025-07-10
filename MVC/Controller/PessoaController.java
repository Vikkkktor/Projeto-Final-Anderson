package com.ifpr.Projeto_Adocao.Controller;

import com.ifpr.Projeto_Adocao.Model.Pessoa;
import com.ifpr.Projeto_Adocao.Services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Pessoa")
@CrossOrigin(origins = "*")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @RequestMapping("/cadastrar")
    public ResponseEntity<String> cadastrarPessoa(@RequestBody Pessoa pessoa){

        String mensagem = pessoaService.CadastroPessoa(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagem);
    }
    @PutMapping ("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, Pessoa pessoa){
        String atualizado = pessoaService.atualizar(id ,pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(atualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir (@PathVariable Long id){
        pessoaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
