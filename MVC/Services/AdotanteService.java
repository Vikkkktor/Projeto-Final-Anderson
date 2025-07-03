package com.ifpr.Projeto_Adocao.Services;
import com.ifpr.Projeto_Adocao.Model.Adotante;
import com.ifpr.Projeto_Adocao.Model.Pessoa;
import com.ifpr.Projeto_Adocao.Util.Util;
import com.ifpr.Projeto_Adocao.repository.AdotanteRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdotanteService {

    @Autowired private AdotanteRepository adotanteRepository;

    public String cadastrarAdotante (Adotante adotante){//Cria um objeto pessoa da classe Pessoa
            Pessoa p=adotanteRepository.existsByNome(adotante.getNome());//Retorna do banco todas as informações da Pessoa
        if (p.getNome().equals(adotante.getNome())){ //Verifica se já existe uma pessoa cadastrada com esse nome
            return "Já existe uma pessoa com esse Nome , use outro por favor!";
        }
        adotanteRepository.save(adotante);
        return "O Cadastro do Adotante foi realizado com sucesso!";
    }
    public String atualizar(Long id, Adotante novosdados) {
        Adotante adotante = adotanteRepository.findById(id) // Bloco e tratamento de erro
                //ele procura o adotante pelo id para fazer atualizaçao do cadastro
                .orElseThrow(() -> new RuntimeException("Adotante não encontrado"));//Caso não encontrar ele mostra isso
        if (Util.validarNome(novosdados.getNome())){
             new IllegalArgumentException("Nome inválido");
        }//Caso contrário ele atualiza
        if (Util.validarEmail(novosdados.getEmail())){
            new IllegalArgumentException("Email inválido");
        }
        if (Util.validarCpf(novosdados.getCpf())){
            new IllegalArgumentException("Cpf inválido");
        }
        adotante.setCep(novosdados.getCep());
        adotante.setCidade(novosdados.getCidade());
        adotante.setEstado(novosdados.getEstado());
        adotante.setLogradouro(novosdados.getLogradouro());
        adotante.setComplemento(novosdados.getComplemento());
        adotante.setTelefone(novosdados.getTelefone());
        adotante.setData_nasc(novosdados.getData_nasc());
        adotanteRepository.save(adotante);
        return "Cadastro do Adotante foi realizado com sucesso!";
    }
    public void excluir(Long id) {
        if (!adotanteRepository.existsById(id)){
            throw new RuntimeException("Adotente não encontrado!");
        }
        adotanteRepository.deleteById(id);

    }

}
