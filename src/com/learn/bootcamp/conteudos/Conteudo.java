package com.learn.bootcamp.conteudos;

import com.learn.bootcamp.Dev;
import com.learn.bootcamp.certificado.Certificado;

public abstract class Conteudo {

    protected static final int XP_PADRAO = 20;

    protected String titulo;
    protected String descricao;
    protected Integer cargaHoraria;
    protected Integer nivel;

    public Conteudo(String titulo, String descricao, Integer cargaHoraria, Integer nivel) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.nivel = nivel;
    }

    public abstract int calcularXp();

    public abstract Certificado gerarCertificado(Dev dev);

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public Integer getNivel() {
        return nivel;
    }

    @Override
    public abstract String toString();

}
