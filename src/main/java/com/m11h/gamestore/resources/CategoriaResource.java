package com.m11h.gamestore.resources;

import com.m11h.gamestore.domain.Categoria;
import com.m11h.gamestore.dto.CategoriaDto;
import com.m11h.gamestore.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> findAll(){
        List<Categoria> listCategoria = categoriaService.findAll();
        List<CategoriaDto> listCategoriaDto = listCategoria.stream().map(CategoriaDto::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listCategoriaDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id){
        Categoria categoria = categoriaService.findById(id);
        return ResponseEntity.ok().body(categoria);
    }
}
