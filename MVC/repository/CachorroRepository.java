package com.ifpr.Projeto_Adocao.repository;

import com.ifpr.Projeto_Adocao.Model.Cachorro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CachorroRepository extends JpaRepository<Cachorro, Long> {

    @Query("SELECT c FROM Cachorro c WHERE c.nome = :nome")
    Cachorro existsByNome(@Param("nome") String nome);

}
