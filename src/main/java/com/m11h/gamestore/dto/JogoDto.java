package com.m11h.gamestore.dto;

import com.m11h.gamestore.domain.Jogo;

import java.io.Serializable;

public class JogoDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String titulo;

    public JogoDto(){}

    public JogoDto(Jogo obj) {
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
