package com.ifpr.Projeto_Adocao.Services;
import com.ifpr.Projeto_Adocao.Model.Passaro;
import com.ifpr.Projeto_Adocao.Util.Util;
import com.ifpr.Projeto_Adocao.repository.PassaroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassaroService {
    @Autowired
    private PassaroRepository passaroRepository;
    public String CadastroPassaro(Passaro passaro){
        Passaro p= passaroRepository.existsByNome(passaro.getNome());
        if (p.getNome().equals(passaro.getNome())){
            return "Já existe um Pássaro com esse nome";
        }
        passaroRepository.save(passaro);
        return "Cadastro Realizado com sucesso!";
    }
    public String atualizar (Long id , Passaro novosdados){
        Passaro passaro = passaroRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Pássaro não encontrado"));
        if ((Util.validarNome(novosdados.getNome()))){
            throw new IllegalArgumentException("Nome inválido");
        }
        passaro.setRaca(novosdados.getRaca());
        passaro.setDescricao(novosdados.getDescricao());
        passaro.setAdotado(novosdados.isAdotado());
        passaroRepository.save(passaro);
        return "Os dados do Pássaro foram atualizados";
    }
    public void excluir(long id){
        if(!passaroRepository.existsById(id)){
            throw new RuntimeException("Passaro não encontrado");
        }
        passaroRepository.deleteById(id);
    }
}
