package com.ifpr.Projeto_Adocao.Controller;

import com.ifpr.Projeto_Adocao.Model.Funcionario;
import com.ifpr.Projeto_Adocao.Services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/cadastrar")
    public ResponseEntity <String> cadastrar(@RequestBody Funcionario funcionario){
        String mensagem = funcionarioService.cadastrofuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagem);
    }

    @PutMapping ("/{id}")
    public ResponseEntity <String> atualizar(@PathVariable Long id,@RequestBody Funcionario funcionario){
        String atualizado = funcionarioService.atualizar(id, funcionario);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> excluir (@PathVariable Long id){
        funcionarioService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
