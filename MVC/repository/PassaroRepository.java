package com.ifpr.Projeto_Adocao.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ifpr.Projeto_Adocao.Model.Passaro;

public interface PassaroRepository extends JpaRepository <Passaro , Long> {
    @Query ("SELECT p FROM Passaro p where p.nome= :nome")
    Passaro existsByNome(@Param("nome")String nome);
}
