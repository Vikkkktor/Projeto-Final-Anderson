package com.ifpr.Projeto_Adocao.Services;
import com.ifpr.Projeto_Adocao.Model.Funcionario;
import com.ifpr.Projeto_Adocao.Util.Util;
import com.ifpr.Projeto_Adocao.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository; //Cria um objeto automaticamente

    public String cadastrofuncionario(Funcionario funcionario) {
        Funcionario f = funcionarioRepository.existsByNome(funcionario.getNome());
        if (f.getNome().equals(funcionario.getNome())) {
            return "Já existe um Funcionário com esse Nome!";

        }
        funcionarioRepository.save(funcionario);
        return "Cadastro realizado com sucesso";
    }
    public String atualizar (Long id, Funcionario novosdados){
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));

        if (Util.validarNome(novosdados.getNome())){
            throw new IllegalArgumentException("Nome inválido!");
        }

        if (Util.validarEmail(novosdados.getEmail())){
            throw new IllegalArgumentException("Email inválido");
        }

        funcionario.setCep(novosdados.getCep());

        if (Util.validarCpf(novosdados.getCpf())){
            throw new IllegalArgumentException("Cpf inválido");
        }
        funcionario.setCargo(novosdados .getCargo());
        funcionario.setSalario(novosdados.getSalario());
        funcionario.setCidade(novosdados.getCidade());
        funcionario.setEstado(novosdados .getEstado());
        funcionario.setLogradouro(novosdados.getLogradouro());
        funcionario.setComplemento(novosdados.getComplemento());
        funcionario.setData_nasc(novosdados .getData_nasc());
        funcionario.setTelefone(novosdados.getTelefone());
        funcionarioRepository.save(funcionario);
        return "Cadastro do Funcionario";
    }
    public void excluir(Long id){
        if (!funcionarioRepository.existsById(id)){
                throw new RuntimeException("Funcionario não encontrado!");
        }
        funcionarioRepository.deleteById(id);
    }
}