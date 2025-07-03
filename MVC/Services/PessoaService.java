package com.ifpr.Projeto_Adocao.Services;

import com.ifpr.Projeto_Adocao.Model.Pessoa;
import com.ifpr.Projeto_Adocao.Util.Util;
import com.ifpr.Projeto_Adocao.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public String CadastroPessoa(Pessoa pessoa) {
        Pessoa  pss=pessoaRepository.existsByNome(pessoa.getNome());
         if (pss.getNome().equals(pessoa.getNome())){
             return "Já tem uma pessoa cadastrada com esse Nome";
         }
        pessoaRepository.save(pessoa);
         return "Castro realizado com sucesso";
    }
    public String atualizar(Long id, Pessoa novosdados){
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        if( Util.validarNome(novosdados .getNome())){
            throw new IllegalArgumentException("O nome está inválido");
        }
       if(Util.validarEmail(novosdados .getEmail())){
           throw new IllegalArgumentException("O Email está errado");
       }
        if(Util.validarCpf(novosdados.getCpf())){
            throw new IllegalArgumentException("O cpf está inválido");
        }
        pessoa.setTelefone(novosdados.getTelefone());
        pessoa.setCidade(novosdados.getCidade());
        pessoa.setEstado(novosdados.getEstado());
        pessoa.setCep(novosdados.getCep());
        pessoa.setLogradouro(novosdados.getLogradouro());
        pessoa.setData_nasc(novosdados.getData_nasc());
        pessoaRepository.save(pessoa);
        return "Os dados foram atualizados";
    }
    public void excluir(Long id){
        if(!pessoaRepository.existsById(id)){
            throw new RuntimeException("Pessoa não encontrada!");
        }
        pessoaRepository.deleteById(id);
    }
}
