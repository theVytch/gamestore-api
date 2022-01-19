package com.m11h.gamestore.dto;

import com.m11h.gamestore.domain.Categoria;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoriaDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    @NotEmpty(message = "Campo NOME é requerido")
    private String nome;

    public CategoriaDto(){}

    public CategoriaDto(Categoria obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
