package com.ifpr.Projeto_Adocao.Services;
import com.ifpr.Projeto_Adocao.Model.Cachorro;
import com.ifpr.Projeto_Adocao.Util.Util;
import com.ifpr.Projeto_Adocao.repository.CachorroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CachorroService {
    @Autowired
    private CachorroRepository cachorroRepository;

    public String CadastroCachorro(Cachorro cachorro) {
        Cachorro c = cachorroRepository.existsByNome(cachorro.getNome());
        if (c.getNome().equals(cachorro.getNome())) {
        return "Já tem um Cachorro cadastrado com esse nome!";

        }
        cachorroRepository.save(cachorro);
        return "Cadastro Realizado com sucesso!";
    }
    public String atualizar (Long id, Cachorro novosdados){
        Cachorro cachorro = cachorroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cachorro não encontrado"));

        if (Util.validarNome(novosdados.getNome())){
            throw new IllegalArgumentException("Nome inválido");
        }
        cachorro.setRaca(novosdados.getRaca());
        cachorro.setAdotado(novosdados.isAdotado());
        cachorro.setDescricao(novosdados.getDescricao());
        cachorro.setData_nasc(novosdados.getData_nasc());
        cachorroRepository.save(cachorro);
        return "Os dados do Cachorro foram atualizados!";
    }
    public void excluir(Long id) {
        if (!cachorroRepository.existsById(id)){
            throw new RuntimeException("Cachorro não encontrado");
        }
        cachorroRepository.deleteById(id);
    }
}