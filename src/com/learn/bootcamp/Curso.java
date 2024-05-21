package com.learn.bootcamp;

import com.learn.bootcamp.enums.Nivel;

public class Curso extends Conteudo {

    public Curso(String titulo, String descricao, Integer cargaHoraria, Integer nivel) {
        super(titulo, descricao, cargaHoraria, nivel);
    }

    @Override
    public int calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    @Override
    public String toString() {
        return "{ Curso: " + titulo +
                " | Nível: " + Nivel.valueOf(nivel) +
                " | Carga Horária: " + cargaHoraria + " hora(s)" +
                " | Descrição: " + descricao +
                " }";
    }

}
