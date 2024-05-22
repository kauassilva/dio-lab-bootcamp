package com.learn.bootcamp;

import com.learn.bootcamp.certificado.Certificado;
import com.learn.bootcamp.conteudos.Conteudo;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {

    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
    private Set<Bootcamp> bootcampsInscritos = new LinkedHashSet<>();
    private Set<Bootcamp> bootcampsConcluidos = new LinkedHashSet<>();
    private Set<Certificado> certificados = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp) {
        bootcampsInscritos.add(bootcamp);
        bootcamp.getDevsInscritos().add(this);
        conteudosInscritos.addAll(bootcamp.getConteudos());
    }

    public void progredir(Conteudo conteudo) {
        verificarConteudosConcluidos(conteudo);
        verificarConteudosInscritos(conteudo);
        conteudosConcluidos.add(conteudo);
        conteudosInscritos.remove(conteudo);

        progredirBootcamp();
    }

    public double calcularTotalXp() {
        return conteudosConcluidos.stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    public void desistirBootcamp(Bootcamp bootcamp) {
        verificarBootcampInscritos(bootcamp);
        bootcampsInscritos.remove(bootcamp);
        conteudosInscritos.removeAll(bootcamp.getConteudos());
    }

    private void verificarBootcampInscritos(Bootcamp bootcamp) {
        boolean existe = bootcampsInscritos.stream()
                .anyMatch(bootcampInscrito -> bootcampInscrito.equals(bootcamp));

        if (!existe) {
            throw new IllegalStateException("Você não está inscrito no bootcamp fornecido!");
        }
    }

    private void progredirBootcamp() {
        Optional<Bootcamp> bootcamp = bootcampsInscritos.stream()
                .filter(bootcampInscrito -> bootcampInscrito.getConteudos().equals(conteudosConcluidos))
                .findAny();

        if (bootcamp.isPresent()) {
            bootcampsInscritos.remove(bootcamp.get());
            bootcampsConcluidos.add(bootcamp.get());
        }
    }

    private void verificarConteudosInscritos(Conteudo conteudo) {
        boolean estaInscrito = conteudosInscritos.stream().anyMatch(conteudoInscrito -> conteudoInscrito == conteudo);

        if (!estaInscrito)
            throw new IllegalStateException("Você não está matriculado neste curso!");
    }

    private void verificarConteudosConcluidos(Conteudo conteudo) {
        boolean foiConcluido = conteudosConcluidos.stream()
                .anyMatch(conteudoConcluido -> conteudoConcluido == conteudo);

        if (foiConcluido)
            throw new IllegalStateException("O conteúdo especificado já foi concluido!");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public Set<Bootcamp> getBootcampsInscritos() {
        return bootcampsInscritos;
    }

    public Set<Bootcamp> getBootcampsConcluidos() {
        return bootcampsConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(getNome(), dev.getNome()) && Objects.equals(getConteudosInscritos(), dev.getConteudosInscritos()) && Objects.equals(getConteudosConcluidos(), dev.getConteudosConcluidos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getConteudosInscritos(), getConteudosConcluidos());
    }

}
