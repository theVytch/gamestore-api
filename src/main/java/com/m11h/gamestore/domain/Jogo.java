package com.m11h.gamestore.domain;

import java.util.Objects;

public class Jogo {
    private Long id;
    private String titulo;
    private String nome_empresa;
    private String descricao;

    private Categoria categoria;

    public Jogo() {
    }

    public Jogo(Long id, String titulo, String nome_empresa, String descricao, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.nome_empresa = nome_empresa;
        this.descricao = descricao;
        this.categoria = categoria;
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

    public String getNome_empresa() {
        return nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogo jogo = (Jogo) o;
        return id.equals(jogo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
