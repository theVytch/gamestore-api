package com.m11h.gamestore.repositories;

import com.m11h.gamestore.domain.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository <Jogo, Long> {
}
