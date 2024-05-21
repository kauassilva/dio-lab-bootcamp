package com.learn.bootcamp.certificado;

import com.learn.bootcamp.enums.TipoCertificado;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Certificado {

    private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int TAMANHO_CREDENCIAL = 8;
    private static final SecureRandom RANDOM = new SecureRandom();

    private final String instituicao = "KDSS";

    private String nomeDev;
    private LocalDate dataFinalizado;
    private String nomeCertificado;
    private Integer cargaHoraria;
    private String credencial;
    private Integer tipoCertificado;

    public Certificado(String nomeDev, LocalDate dataFinalizado, String nomeCertificado, Integer cargaHoraria, Integer tipoCertificado) {
        this.nomeDev = nomeDev;
        this.dataFinalizado = dataFinalizado;
        this.nomeCertificado = nomeCertificado;
        this.cargaHoraria = cargaHoraria;
        this.tipoCertificado = tipoCertificado;
        credencial = gerarCredencial();
    }

    private static String gerarCredencial() {
        StringBuilder credencial = new StringBuilder(TAMANHO_CREDENCIAL);

        for (int i=0; i<TAMANHO_CREDENCIAL; i++) {
            int indice = RANDOM.nextInt(CARACTERES.length());
            credencial.append(CARACTERES.charAt(indice));
        }

        return credencial.toString();
    }

    public String getInstituicao() {
        return instituicao;
    }

    public String getNomeDev() {
        return nomeDev;
    }

    public LocalDate getDataFinalizado() {
        return dataFinalizado;
    }

    public String getNomeCertificado() {
        return nomeCertificado;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public String getCredencial() {
        return credencial;
    }

    public Integer getTipoCertificado() {
        return tipoCertificado;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFinalizadoFormatada = dataFinalizado.format(formatacao);

        return "{ A " + instituicao +
                " certifica que o(a) " + nomeDev +
                " completou na data " + dataFinalizadoFormatada +
                ", o " + TipoCertificado.valueOf(tipoCertificado) + ": " + nomeCertificado +
                ". Com uma carga horária de " + cargaHoraria + " horas." +
                " | Credencial: " + credencial +
                " }";
    }

}
