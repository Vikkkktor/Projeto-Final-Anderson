package com.ifpr.Projeto_Adocao.Controller;

import com.ifpr.Projeto_Adocao.Model.Adocao;
import com.ifpr.Projeto_Adocao.Services.AdocaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable; // Importar Pageable
import org.springframework.data.web.PageableDefault; // Importar PageableDefault
import org.springframework.data.domain.Sort; // Importar Sort

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adocao")
@CrossOrigin(origins = "*")
public class AdocaoController {

    @Autowired
    private AdocaoService adocaoService;

    // Endpoint para listar todas as adoções (sem filtro ou ordenação padrão)
    @GetMapping
    public ResponseEntity<List<Adocao>> getAllAdocoes() {
        List<Adocao> adocoes = adocaoService.buscarTodosAnimaisParaAdocao();
        return ResponseEntity.ok(adocoes);
    }

    // Endpoint para buscar adoção por ID
    @GetMapping("/{id}")
    public ResponseEntity<Adocao> getAdocaoById(@PathVariable Long id) {
        Optional<Adocao> adocao = adocaoService.buscarAdocaoPorId(id);
        return adocao.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ENDPOINT DE FILTRO COMBINADO COM ORDENAÇÃO
    // Ex: GET /adocao/filtro?tipo=Gato&sort=nomeAnimal,asc
    // Ex: GET /adocao/filtro?porte=Pequeno&sort=idade,desc
    // Ex: GET /adocao/filtro?sort=nomeAnimal,asc&sort=porte,asc
    @GetMapping("/filtro")
    public ResponseEntity<List<Adocao>> getAdocoesByMultipleFilters(
            @RequestParam(required = false) String tipo,
            @RequestParam(required = false) String porte,
            @RequestParam(required = false) String idade,
            @RequestParam(required = false) String nome,
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) { // Pageable para ordenação e paginação

        List<Adocao> adocoes = adocaoService.buscarAnimaisPorFiltro(tipo, porte, idade, nome, pageable);

        if (adocoes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(adocoes);
    }

    // Endpoints específicos por tipo, agora também com ordenação
    // Ex: GET /adocao/gatos?sort=nomeAnimal,asc
    @GetMapping("/gatos")
    public ResponseEntity<List<Adocao>> getAllGatosForAdocao(
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        List<Adocao> gatos = adocaoService.buscarGatos(pageable);
        return ResponseEntity.ok(gatos);
    }

    // Ex: GET /adocao/cachorros?sort=nomeAnimal,desc
    @GetMapping("/cachorros")
    public ResponseEntity<List<Adocao>> getAllCachorrosForAdocao(
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        List<Adocao> cachorros = adocaoService.buscarCachorros(pageable);
        return ResponseEntity.ok(cachorros);
    }

    // Ex: GET /adocao/passaros?sort=porte,asc
    @GetMapping("/passaros")
    public ResponseEntity<List<Adocao>> getAllPassarosForAdocao(
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        List<Adocao> passaros = adocaoService.buscarPassaros(pageable);
        return ResponseEntity.ok(passaros);
    }

    // Endpoint para simular o cadastro de uma adoção para testar
    @PostMapping
    public ResponseEntity<Adocao> createAdocao(@RequestBody Adocao adocao) {
        Adocao savedAdocao = adocaoService.salvarAdocao(adocao);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAdocao);
    }

    // Método para salvar uma lista de adocoes para facilitar o teste
    @PostMapping("/batch")
    public ResponseEntity<List<Adocao>> createMultipleAdocoes(@RequestBody List<Adocao> adocoes) {
        List<Adocao> savedAdocoes = adocaoService.salvarTodasAdocoes(adocoes);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAdocoes);
    }
}