package com.m11h.gamestore.services;

import com.m11h.gamestore.domain.Categoria;
import com.m11h.gamestore.domain.Jogo;
import com.m11h.gamestore.repositories.JogoRepository;
import com.m11h.gamestore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;
    @Autowired
    private CategoriaService categoriaService;

    public List<Jogo> findAll(Long id_cat){
        categoriaService.findById(id_cat);
        return jogoRepository.findAllByCategoria(id_cat);
    }

    public Jogo findById(Long id){
        Optional<Jogo> obj = jogoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não foi encontrado! id: " + id + ", Tipo: " + Jogo.class.getName()));
    }

    public Jogo create(Jogo obj){
        obj.setId(null);
        return jogoRepository.save(obj);
    }

    public Jogo update(Long id, Jogo obj) {
        Jogo newObj = findById(id);
        updateData(newObj, obj);
        return jogoRepository.save(newObj);
    }

    private void updateData(Jogo newObj, Jogo obj) {
        newObj.setTitulo(obj.getTitulo());
        newObj.setNome_empresa(obj.getNome_empresa());
        newObj.setDescricao(obj.getDescricao());
    }

    public Jogo create(Long id_cat, Jogo obj) {
        obj.setId(null);
        Categoria cat = categoriaService.findById(id_cat);
        obj.setCategoria(cat);
        return jogoRepository.save(obj);
    }

    public void delete(Long id) {
        Jogo obj = findById(id);
       jogoRepository.delete(obj);
    }
}
