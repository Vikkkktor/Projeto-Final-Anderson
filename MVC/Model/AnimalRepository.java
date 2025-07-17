package com.ifpr.Projeto_Adocao.repository;
import com.ifpr.Projeto_Adocao.Model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AnimalRepository extends JpaRepository <Animal,Long > {

    @Query ("Select aAnimal from Animal aAnimal where aAnimal.nome=:Nome")
    Animal existsbyNome(@Param("Nome")String nome);
}
