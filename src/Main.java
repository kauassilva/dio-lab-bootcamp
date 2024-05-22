import com.learn.bootcamp.Bootcamp;
import com.learn.bootcamp.Dev;
import com.learn.bootcamp.conteudos.Conteudo;
import com.learn.bootcamp.conteudos.Curso;
import com.learn.bootcamp.conteudos.Mentoria;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        Conteudo curso1 = new Curso("Java Básico", "Melhor curso para sair do zero em Java.", 21, 1);
        Conteudo curso2 = new Curso("API Stream do Java", "Aprenda a como utilizar a API Stream para melhorar seu código.", 2, 2);
        Conteudo mentoria1 = new Mentoria("Mentoria de Java", "Se prepare para entender alguns padrões para o seu código Java.", 2, 1, LocalDateTime.now().plusDays(2));

        Bootcamp bootcamp1 = new Bootcamp("Bootcamp Java Developer", "Aprenda a ser um main Java Developer!");
        bootcamp1.adicionarConteudo(curso1);
        bootcamp1.adicionarConteudo(curso2);
        bootcamp1.adicionarConteudo(mentoria1);

        Conteudo curso3 = new Curso("Python Básico", "Aprenda a sair do zero em Python.", 19, 1);

        Bootcamp bootcamp2 = new Bootcamp("Bootcamp Python Developer", "Aprenda a usar o Python.");
        bootcamp2.adicionarConteudo(curso3);

        Dev dev1 = new Dev();
        dev1.setNome("Camila");
        dev1.inscreverBootcamp(bootcamp1);
        dev1.inscreverBootcamp(bootcamp2);
        dev1.progredir(curso2);
        dev1.progredir(curso1);
        dev1.progredir(mentoria1);

        System.out.println("\nConteúdos inscritos: " + dev1.getConteudosInscritos());
        System.out.println("\nConteúdos concluídos: " + dev1.getConteudosConcluidos());
        System.out.println("\nBootcamps inscritos: " + dev1.getBootcampsInscritos());
        System.out.println("\nBootcamps concluídos: " + dev1.getBootcampsConcluidos());

        dev1.desistirBootcamp(bootcamp2);

        System.out.println("\nConteúdos inscritos: " + dev1.getConteudosInscritos());
        System.out.println("\nConteúdos concluídos: " + dev1.getConteudosConcluidos());
        System.out.println("\nBootcamps inscritos: " + dev1.getBootcampsInscritos());
        System.out.println("\nBootcamps concluídos: " + dev1.getBootcampsConcluidos());

        System.out.println("Certificados: " + dev1.getCertificados());

    }

}