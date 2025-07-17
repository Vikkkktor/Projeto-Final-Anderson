package com.ifpr.Projeto_Adocao.Controller;

import com.ifpr.Projeto_Adocao.Model.Adotante;
import com.ifpr.Projeto_Adocao.Services.AdotanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Pessoa")
@CrossOrigin(origins = "*")
public class AdotanteController {

    @Autowired
    private AdotanteService adotanteService;

    @RequestMapping("/cadastrar")
    public ResponseEntity<String> cadastrarAdotante(@RequestBody Adotante adotante){

        String mensagem = adotanteService.CadastrarAdotante(adotante);
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagem);
    }
    @PutMapping ("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, Adotante adotante){
        String atualizado = adotanteService.atualizar(id , adotante);
        return ResponseEntity.status(HttpStatus.CREATED).body(atualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir (@PathVariable Long id){
        adotanteService.excluir(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Adotante loginRequest) {
        String resultado = adotanteService.realizarLogin(loginRequest.getEmail(), loginRequest.getSenha());
        if ("Login bem-sucedido!".equals(resultado)) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(resultado);
        }
    }
    @GetMapping
    public ResponseEntity<List<Adotante>> lis() {
        List<Adotante> adotante = adotanteService.listarAdotantes(); // Chama um novo metodo no serviço
        return ResponseEntity.ok(adotante);
    }

    // Buscar animal por ID
    @GetMapping("/{id}")
    public ResponseEntity<Adotante> buscarAnimalPorId(@PathVariable Long id) {
        Adotante adotante = adotanteService.buscarAdotantePorId(id); // Chama um novo metodo no serviço
        if (adotante != null) {
            return ResponseEntity.ok(adotante   );
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
