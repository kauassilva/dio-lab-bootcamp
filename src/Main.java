import com.learn.bootcamp.*;
import com.learn.bootcamp.certificado.Certificado;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        Conteudo curso1 = new Curso("Java Básico", "Melhor curso para sair do zero em Java.", 21, 1);

        Conteudo curso2 = new Curso("API Stream do Java", "Aprenda a como utilizar a API Stream para melhorar seu código.", 2, 2);

        Conteudo mentoria1 = new Mentoria("Mentoria de Java", "Se prepare para entender alguns padrões para o seu código Java.", 2, 1, LocalDateTime.now().plusDays(2));

        Bootcamp bootcamp = new Bootcamp("Bootcamp Java Developer", "Aprenda a ser um main Java Developer!");
        bootcamp.adicionarConteudo(curso1);
        bootcamp.adicionarConteudo(curso2);
        bootcamp.adicionarConteudo(mentoria1);

        Dev dev1 = new Dev();
        dev1.setNome("Camila");
        dev1.inscreverBootcamp(bootcamp);

        Certificado certificado1 = new Certificado(dev1.getNome(), LocalDate.now(), bootcamp.getNome(), bootcamp.calcularHoraTotal(), 3);

        System.out.println("\n" + bootcamp);
        System.out.println("\n" + certificado1);
        System.out.println("\n" + curso1);
        System.out.println("\n" + curso2);
        System.out.println("\n" + mentoria1);

    }

}