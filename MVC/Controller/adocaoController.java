package com.ifpr.Projeto_Adocao.Controller;
import com.ifpr.Projeto_Adocao.Model.Adocao;
import com.ifpr.Projeto_Adocao.Model.Adotante;
import com.ifpr.Projeto_Adocao.Services.adocaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/adocoes")
@CrossOrigin(origins = "*")
public class adocaoController {
    @Autowired
    private adocaoService service;

    @PostMapping
    public ResponseEntity<Adocao> salvar(@RequestBody Adocao adocao){
        return ResponseEntity.ok(service.salvar(adocao));
    }
    @GetMapping
    public ResponseEntity<List<Adocao>> listar(){
        return ResponseEntity.ok(service.listar());
    }


}
