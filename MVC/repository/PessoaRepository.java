package com.ifpr.Projeto_Adocao.repository;

import com.ifpr.Projeto_Adocao.Model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PessoaRepository extends JpaRepository <Pessoa , Long> {
    @Query("SELECT pss FROM Pessoa pss where pss.nome= :nome")
    Pessoa existsByNome(@Param("nome")String nome);
}
