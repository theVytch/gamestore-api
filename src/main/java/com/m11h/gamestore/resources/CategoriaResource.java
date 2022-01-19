package com.m11h.gamestore.resources;

import com.m11h.gamestore.domain.Categoria;
import com.m11h.gamestore.dto.CategoriaDto;
import com.m11h.gamestore.services.CategoriaService;
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

    @PostMapping
    public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria obj){
        obj = categoriaService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDto> update(@Valid @PathVariable Long id, @RequestBody CategoriaDto objDto){
        Categoria newObj = categoriaService.update(id, objDto);
        return ResponseEntity.ok().body(new CategoriaDto(newObj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
