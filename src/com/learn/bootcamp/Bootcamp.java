package com.learn.bootcamp;

import com.learn.bootcamp.certificado.Certificado;
import com.learn.bootcamp.conteudos.Conteudo;
import com.learn.bootcamp.enums.Nivel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

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

    public Certificado gerarCertificado(Dev dev) {
        return new Certificado(dev.getNome(), LocalDate.now(), nome, calcularHoraTotal(), 3);
    }

    private int calcularTotalDevsIncritos() {
        return devsInscritos.size();
    }

    private int calcularTotalConteudo() {
        return conteudos.size();
    }

    private Nivel calcularNivelBase() {
        Optional<Conteudo> conteudo = conteudos.stream().min(Comparator.comparingInt(Conteudo::getNivel));

        if (conteudo.isEmpty())
            throw new NoSuchElementException("Nenhum conteúdo encontrado com o nível especificado!");

        return Nivel.valueOf(conteudo.get().getNivel());
    }

    private Nivel calcularNivelMaximo() {
        Optional<Conteudo> conteudo = conteudos.stream().max(Comparator.comparingInt(Conteudo::getNivel));

        if (conteudo.isEmpty())
            throw new NoSuchElementException("Nenhum conteúdo encontrado com o nível especificado!");

        return Nivel.valueOf(conteudo.get().getNivel());
    }

    private String exibirNivel() {
        Nivel nivelBase = calcularNivelBase();
        Nivel nivelMaximo = calcularNivelMaximo();

        return nivelBase == nivelMaximo ? nivelBase.toString() : nivelBase + " - " + nivelMaximo;
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
        return Objects.equals(getNome(), bootcamp.getNome()) && Objects.equals(getConteudos(), bootcamp.getConteudos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getConteudos());
    }

    @Override
    public String toString() {
        DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataInicialFormatada = dataInicial.format(formatacao);
        String dataFinalFormatada = dataFinal.format(formatacao);

        return "{ Nome: " + nome +
                " | Range de nível: " + exibirNivel() +
                " | Carga Horária: " + calcularHoraTotal() +
                " | Devs Inscritos: " + calcularTotalDevsIncritos() +
                " | Descrição: " + descricao +
                " | Data inicial: " + dataInicialFormatada +
                " | Data de Encerramentos: " + dataFinalFormatada +
                " | Total de Conteúdos: " + calcularTotalConteudo() +
                " }";
    }

}
