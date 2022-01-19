package com.m11h.gamestore.services;

import com.m11h.gamestore.domain.Categoria;
import com.m11h.gamestore.domain.Jogo;
import com.m11h.gamestore.dto.CategoriaDto;
import com.m11h.gamestore.repositories.CategoriaRepository;
import com.m11h.gamestore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    public Categoria findById(Long id){
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não foi encontrado! id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public Categoria create(Categoria obj){
        obj.setId(null);
        return categoriaRepository.save(obj);
    }

    public Categoria update(Long id, CategoriaDto objDto) {
        Categoria obj = findById(id);
        obj.setNome(objDto.getNome());
        return categoriaRepository.save(obj);
    }

    public void delete(Long id) {
        findById(id);
        try {
            categoriaRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new com.m11h.gamestore.services.exceptions.DataIntegrityViolationException(
                    "Objeto não pode ser deletado! Possui jogos associados");
        }
    }

}
