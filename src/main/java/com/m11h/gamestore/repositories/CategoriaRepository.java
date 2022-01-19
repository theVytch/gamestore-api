package com.m11h.gamestore.repositories;

import com.m11h.gamestore.domain.Categoria;
import com.m11h.gamestore.domain.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository <Categoria, Long> {
}
