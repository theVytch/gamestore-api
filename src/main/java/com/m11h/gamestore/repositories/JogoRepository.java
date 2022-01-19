package com.m11h.gamestore.repositories;

import com.m11h.gamestore.domain.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogoRepository extends JpaRepository <Jogo, Long> {

    @Query("SELECT obj FROM tb_jogo obj WHERE obj.categoria.id = :id_cat ORDER BY titulo")
    List<Jogo> findAllByCategoria(@Param(value = "id_cat") Long id_cat);
}
