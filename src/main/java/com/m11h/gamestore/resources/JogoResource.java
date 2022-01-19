package com.m11h.gamestore.resources;

import com.m11h.gamestore.domain.Jogo;
import com.m11h.gamestore.services.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/jogos")
public class JogoResource {

    @Autowired
    private JogoService jogoService;

    @GetMapping
    public ResponseEntity<List<Jogo>> findAll(){
        List<Jogo> jogos = jogoService.findAll();
        return ResponseEntity.ok().body(jogos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogo> findById(@PathVariable Long id){
        Jogo jogo = jogoService.findById(id);
        return ResponseEntity.ok().body(jogo);
    }
}
