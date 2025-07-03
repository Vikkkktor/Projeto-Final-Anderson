package com.ifpr.Projeto_Adocao.Controller;
import com.ifpr.Projeto_Adocao.Model.Passaro;
import com.ifpr.Projeto_Adocao.Services.PassaroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passaro")
public class PassaroController {
    @Autowired
    private PassaroService passaroService;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarPassaro(@RequestBody Passaro passaro){
        String mensagem = passaroService.CadastroPassaro(passaro);
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagem);

    }
    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, Passaro passaro){
        String atualizado = passaroService.atualizar(id,passaro);
        return ResponseEntity.ok(atualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> exclur(@PathVariable Long id){
        passaroService.excluir(id);
        return ResponseEntity.noContent().build();

    }
}
