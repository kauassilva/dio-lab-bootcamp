package com.learn.bootcamp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {

    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFinal = dataInicial.plusDays(90);

    private String nome;
    private String descricao;
    private Set<Dev> devsInscritos = new HashSet<>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();

    public Bootcamp(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public void adicionarConteudo(Conteudo conteudo) {
        if (conteudo == null)
            throw new NullPointerException("O conteúdo não pode ser nulo!");

        conteudos.add(conteudo);
    }

    public int calcularHoraTotal() {
        return conteudos.stream()
                .mapToInt(conteudo -> conteudo.getCargaHoraria() != null ? conteudo.getCargaHoraria() : 0)
                .sum();
    }

    private int calcularTotalDevsIncritos() {
        return devsInscritos.size();
    }

    private int calcularTotalConteudo() {
        return conteudos.size();
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Dev> getDevsInscritos() {
        return devsInscritos;
    }

    public void setDevsInscritos(Set<Dev> devsInscritos) {
        this.devsInscritos = devsInscritos;
    }

    public Set<Conteudo> getConteudos() {
        return conteudos;
    }

    public void setConteudos(Set<Conteudo> conteudos) {
        this.conteudos = conteudos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(getDataInicial(), bootcamp.getDataInicial()) && Objects.equals(getDataFinal(), bootcamp.getDataFinal()) && Objects.equals(getNome(), bootcamp.getNome()) && Objects.equals(getDescricao(), bootcamp.getDescricao()) && Objects.equals(getDevsInscritos(), bootcamp.getDevsInscritos()) && Objects.equals(getConteudos(), bootcamp.getConteudos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDataInicial(), getDataFinal(), getNome(), getDescricao(), getDevsInscritos(), getConteudos());
    }

    @Override
    public String toString() {
        DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataInicialFormatada = dataInicial.format(formatacao);
        String dataFinalFormatada = dataFinal.format(formatacao);

        return "{ Nome: " + nome +
                " | Carga Horária: " + calcularHoraTotal() +
                " | Devs Inscritos: " + calcularTotalDevsIncritos() +
                " | Descrição: " + descricao +
                " | Data inicial: " + dataInicialFormatada +
                " | Data de Encerramentos: " + dataFinalFormatada +
                " | Total de Conteúdos: " + calcularTotalConteudo() +
                " }";
    }

}
