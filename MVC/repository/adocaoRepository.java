package com.ifpr.Projeto_Adocao.repository;
import com.ifpr.Projeto_Adocao.Model.Adocao;
import com.ifpr.Projeto_Adocao.Model.Passaro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface adocaoRepository extends JpaRepository<Adocao,Long> {
//    @Query("SELECT ad FROM Adocao where ad.nome= :nome")
//    Passaro existsByNome(@Param("nome")String nome);
}
