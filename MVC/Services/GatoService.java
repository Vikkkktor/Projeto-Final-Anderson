package com.ifpr.Projeto_Adocao.Services;
import com.ifpr.Projeto_Adocao.Model.Gato;
import com.ifpr.Projeto_Adocao.Util.Util;
import com.ifpr.Projeto_Adocao.repository.GatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GatoService {
    @Autowired
    private GatoRepository gatoRepository;

    public String cadastroGato (Gato gato){
        Gato g=gatoRepository.existsByNome(gato.getNome());
        if (g.getNome().equals(gato.getNome())){
            return "Já tem um Gato com esse nome";
        }
        gatoRepository.save(gato);
        return "Cadastro do Gato realizado com sucesso";
    }
    public String atualizar(Long id, Gato novosdados){
        Gato gato = gatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gato não encontrado"));
        if(Util.validarNome(novosdados.getNome())){
            throw new IllegalArgumentException("Nome inválido");
        }
        gato.setRaca(novosdados.getRaca());
        gato.setAdotado(novosdados.isAdotado());
        gato.setDescricao(novosdados.getDescricao());
        gato.setData_nasc(novosdados.getData_nasc());
        gatoRepository.save(gato);
        return "Cadastro do gato realizado com sucesso!";

    }
    public void excluir(long id){
       if (!gatoRepository.existsById(id)) {
            throw new RuntimeException("Gato não encontrado");
        }
        gatoRepository.deleteById(id);
    }

}
