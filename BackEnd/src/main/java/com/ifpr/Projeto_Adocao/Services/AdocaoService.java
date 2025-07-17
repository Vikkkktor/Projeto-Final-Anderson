package com.ifpr.Projeto_Adocao.Services;

import com.ifpr.Projeto_Adocao.Model.Adocao;
import com.ifpr.Projeto_Adocao.repository.adocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdocaoService {
    @Autowired
    private adocaoRepository adocaoRepository;

    public List<Adocao> buscarTodosAnimaisParaAdocao() {
        return adocaoRepository.findAll();
    }

    public Optional<Adocao> buscarAdocaoPorId(Long id) {
        return adocaoRepository.findById(id);
    }

    public List<Adocao> salvarTodasAdocoes(List<Adocao> adocoes) {
        return adocaoRepository.saveAll(adocoes);
    }

    // Método de filtro flexível com ordenação
    public List<Adocao> buscarAnimaisPorFiltro(String tipoAnimal, String porte, String idade, String nomeAnimal, Pageable pageable) {
        String finalTipo = (tipoAnimal != null && !tipoAnimal.isEmpty()) ? tipoAnimal : null;
        String finalPorte = (porte != null && !porte.isEmpty()) ? porte : null;
        String finalIdade = (idade != null && !idade.isEmpty()) ? idade : null;
        String finalNome = (nomeAnimal != null && !nomeAnimal.isEmpty()) ? nomeAnimal : null;

        return adocaoRepository.findByCriteria(finalTipo, finalPorte, finalIdade, finalNome, pageable);
    }

    // Métodos específicos por tipo, agora usando findByAnimal_EspecieIgnoreCase
    public List<Adocao> buscarGatos(Pageable pageable) {
        return adocaoRepository.findByAnimal_EspecieIgnoreCase("Gato", pageable);
    }

    public List<Adocao> buscarCachorros(Pageable pageable) {
        return adocaoRepository.findByAnimal_EspecieIgnoreCase("Cachorro", pageable);
    }

    public List<Adocao> buscarPassaros(Pageable pageable) {
        return adocaoRepository.findByAnimal_EspecieIgnoreCase("Passaro", pageable);
    }

    public Adocao salvarAdocao(Adocao adocao) {
        return adocaoRepository.save(adocao);
    }
}
