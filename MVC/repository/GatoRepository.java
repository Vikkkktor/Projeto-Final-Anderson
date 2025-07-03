package com.ifpr.Projeto_Adocao.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ifpr.Projeto_Adocao.Model.Gato;
public interface GatoRepository extends JpaRepository<Gato,Long> {
    @Query ("SELECT g From gato g where g.nome= :nome")
    Gato existsByNome(@Param("nome")String nome);

}
