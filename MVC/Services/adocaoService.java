package com.ifpr.Projeto_Adocao.Services;
import com.ifpr.Projeto_Adocao.Model.Adocao;
import com.ifpr.Projeto_Adocao.repository.adocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class adocaoService {
    @Autowired
    private adocaoRepository repository;

    public Adocao salvar(Adocao adocao){
        return repository.save(adocao);
    }
    public List<Adocao> listar() {
        return repository.findAll();
    }

}
