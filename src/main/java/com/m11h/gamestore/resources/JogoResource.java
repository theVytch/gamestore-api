package com.m11h.gamestore.resources;

import com.m11h.gamestore.domain.Jogo;
import com.m11h.gamestore.dto.CategoriaDto;
import com.m11h.gamestore.dto.JogoDto;
import com.m11h.gamestore.services.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/jogos")
public class JogoResource {

    @Autowired
    private JogoService jogoService;

    @GetMapping
    public ResponseEntity<List<JogoDto>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Long id_cat){
        List<Jogo> listJogo = jogoService.findAll(id_cat);
        List<JogoDto> listJogoDto = listJogo.stream().map(JogoDto::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listJogoDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogo> findById(@PathVariable Long id){
        Jogo jogo = jogoService.findById(id);
        return ResponseEntity.ok().body(jogo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogo> update(@PathVariable Long id,@Valid @RequestBody Jogo obj){
        Jogo newObj = jogoService.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PostMapping
    public ResponseEntity<Jogo> create(@Valid @RequestParam(value = "categoria", defaultValue = "0") Long id_cat,@Valid @RequestBody Jogo obj){
        Jogo newObj = jogoService.create(id_cat, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/jogos/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        jogoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
