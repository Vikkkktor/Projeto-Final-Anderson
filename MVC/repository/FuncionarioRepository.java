package com.ifpr.Projeto_Adocao.repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import com.ifpr.Projeto_Adocao.Model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository <Funcionario , Long> {

    @Query ("Select F from Funcionario F where f.nome= :nome")
    Funcionario existsByNome (@Param("nome")String nome);

}
