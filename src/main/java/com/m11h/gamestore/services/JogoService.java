package com.m11h.gamestore.services;

import com.m11h.gamestore.domain.Jogo;
import com.m11h.gamestore.repositories.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    public List<Jogo> findAll(){
        return jogoRepository.findAll();
    }

    public Jogo findById(Long id){
        Optional<Jogo> obj = jogoRepository.findById(id);
        return obj.orElse(null);
    }
}
