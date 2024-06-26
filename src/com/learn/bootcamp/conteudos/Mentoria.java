package com.learn.bootcamp.conteudos;

import com.learn.bootcamp.Dev;
import com.learn.bootcamp.certificado.Certificado;
import com.learn.bootcamp.enums.Nivel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mentoria extends Conteudo {

    private static final int XP_BONUS = 50;

    private LocalDateTime dataHora;

    public Mentoria(String titulo, String descricao, Integer cargaHoraria, Integer nivel, LocalDateTime dataHora) {
        super(titulo, descricao, cargaHoraria, nivel);
        this.dataHora = dataHora;
    }

    @Override
    public int calcularXp() {
        return XP_PADRAO * cargaHoraria + XP_BONUS;
    }

    @Override
    public Certificado gerarCertificado(Dev dev) {
        return new Certificado(dev.getNome(), LocalDate.now(), titulo, cargaHoraria, 2);
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatacaoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatacaoHora = DateTimeFormatter.ofPattern("HH:mm");
        String dataFormatada = dataHora.format(formatacaoData);
        String horaFormatada = dataHora.format(formatacaoHora);

        return "{ Mentoria " + titulo +
                " | Data: " + dataFormatada +
                " | Horário: " + horaFormatada +
                " | Carga Horária: " + cargaHoraria +
                " | Nível: " + Nivel.valueOf(nivel) +
                " | Descrição: " + descricao +
                " }";
    }

}
