package com.learn.bootcamp.conteudos;

import com.learn.bootcamp.Dev;
import com.learn.bootcamp.certificado.Certificado;
import com.learn.bootcamp.enums.Nivel;

import java.time.LocalDate;

public class Curso extends Conteudo {

    public Curso(String titulo, String descricao, Integer cargaHoraria, Integer nivel) {
        super(titulo, descricao, cargaHoraria, nivel);
    }

    @Override
    public int calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    @Override
    public Certificado gerarCertificado(Dev dev) {
        return new Certificado(dev.getNome(), LocalDate.now(), titulo, cargaHoraria, 1);
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
