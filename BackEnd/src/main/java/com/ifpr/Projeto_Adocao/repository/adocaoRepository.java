package com.ifpr.Projeto_Adocao.repository;
import com.ifpr.Projeto_Adocao.Model.Adocao;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface adocaoRepository extends JpaRepository<Adocao,Long> {

    // Metodo de filtro combinado com Pageable para ordenação e paginação
    // Acessando os campos do Animal através da relação 'a.animal'
    @Query("SELECT a FROM Adocao a " +
            "WHERE (:tipo IS NULL OR LOWER(a.animal.especie) = LOWER(:tipo)) " +
            "  AND (:porte IS NULL OR LOWER(a.animal.porte) = LOWER(:porte)) " +
            "  AND (:idadeCat IS NULL OR LOWER(a.animal.idade) = LOWER(:idadeCat)) " +
            "  AND (:nome IS NULL OR LOWER(a.animal.nome) LIKE LOWER(CONCAT('%', :nome, '%')))")
    List<Adocao> findByCriteria(
            @Param("tipo") String tipo,
            @Param("porte") String porte,
            @Param("idadeCat") String idadeCat,
            @Param("nome") String nome,
            Pageable pageable);


    List<Adocao> findByAnimal_EspecieIgnoreCase(String especie, Pageable pageable);

    List<Adocao> findByAnimal_NomeContainingIgnoreCase(String nome, Pageable pageable);
    List<Adocao> findByAnimal_PorteIgnoreCase(String porte, Pageable pageable);
    List<Adocao> findByAnimal_IdadeIgnoreCase(String idade, Pageable pageable);
}
