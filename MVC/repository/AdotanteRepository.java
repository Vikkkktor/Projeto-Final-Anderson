package com.ifpr.Projeto_Adocao.repository;
import com.ifpr.Projeto_Adocao.Model.Adotante;
import com.ifpr.Projeto_Adocao.Model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdotanteRepository extends JpaRepository <Adotante, Long> {

    //Somente select dentro do repository
    @Query ("Select pAdotante from Pessoa pAdotante where pAdotante.nome=:Nome")
    Pessoa existsByNome(@Param("Nome") String nome);

}
