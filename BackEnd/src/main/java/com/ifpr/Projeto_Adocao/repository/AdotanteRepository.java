package com.ifpr.Projeto_Adocao.repository;

import com.ifpr.Projeto_Adocao.Model.Adotante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdotanteRepository extends JpaRepository<Adotante, Long> {


    Adotante findByLoginAndSenha(String login, String senha);

    boolean existsByNome(String nome);


    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);

}
