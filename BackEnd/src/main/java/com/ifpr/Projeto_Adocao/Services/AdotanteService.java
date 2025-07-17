package com.ifpr.Projeto_Adocao.Services;

import com.ifpr.Projeto_Adocao.Model.Adotante;
import com.ifpr.Projeto_Adocao.Util.Util;
import com.ifpr.Projeto_Adocao.repository.AdotanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdotanteService {
    @Autowired
    private AdotanteRepository adotanteRepository;

    public String CadastrarAdotante(Adotante adotante) {
        // --- A CORREÇÃO ESTÁ AQUI ---
        // existsByNome retorna um boolean, então a variável 'existe' deve ser boolean.
        // Você não pode chamar .getNome() em um boolean.
        if (adotanteRepository.existsByNome(adotante.getNome())) {
            return "Já existe um adotante cadastrado com esse Nome.";
        }
        // Se você também quiser verificar por CPF ou Email antes de cadastrar para garantir unicidade
        if (adotanteRepository.existsByCpf(adotante.getCpf())) {
            return "Já existe um adotante cadastrado com esse CPF.";
        }
        if (adotanteRepository.existsByEmail(adotante.getEmail())) {
            return "Já existe um adotante cadastrado com esse Email.";
        }

        adotanteRepository.save(adotante);
        return "Cadastro realizado com sucesso!";
    }

    public String atualizar(Long id, Adotante novosdados) {
        Adotante adotante = adotanteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        // As validações devem verificar se os novos dados são válidos
        if (Util.validarNome(novosdados.getNome())) {
            throw new IllegalArgumentException("O nome está inválido");
        }
        if (Util.validarEmail(novosdados.getEmail())) {
            throw new IllegalArgumentException("O Email está errado");
        }
        if (Util.validarCpf(novosdados.getCpf())) {
            throw new IllegalArgumentException("O cpf está inválido");
        }

        // Atualizar apenas os campos que você deseja permitir a atualização
        adotante.setNome(novosdados.getNome()); // Adicionei o nome, se for para atualizar
        adotante.setEmail(novosdados.getEmail()); // Adicionei o email, se for para atualizar
        adotante.setCpf(novosdados.getCpf()); // Adicionei o CPF, se for para atualizar
        adotante.setTelefone(novosdados.getTelefone());
        adotante.setCidade(novosdados.getCidade());
        adotante.setEstado(novosdados.getEstado());
        adotante.setCep(novosdados.getCep());
        adotante.setLogradouro(novosdados.getLogradouro());
        adotante.setComplemento(novosdados.getComplemento()); // Adicionei complemento
        adotante.setDate_nas(novosdados.getDate_nas()); // Adicionei data de nascimento
        adotante.setSenha(novosdados.getSenha()); // Cuidado ao atualizar senhas, considere criptografia

        adotanteRepository.save(adotante);
        return "Os dados foram atualizados";
    }

    public void excluir(Long id) {
        if (!adotanteRepository.existsById(id)) {
            throw new RuntimeException("Pessoa não encontrada!");
        }
        adotanteRepository.deleteById(id);
    }

    public String realizarLogin(String login, String senha) {
        Adotante adotante = adotanteRepository.findByLoginAndSenha(login, senha);
        if (adotante != null) {
            return "Login bem-sucedido!";
        } else {
            return "Login ou senha inválidos.";
        }
    }

    public List<Adotante> listarAdotantes() {
        return adotanteRepository.findAll();
    }

    // Buscar adotante por ID
    public Adotante buscarAdotantePorId(Long id) {
        return adotanteRepository.findById(id).orElse(null);
    }
}
