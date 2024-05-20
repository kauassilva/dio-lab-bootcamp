import com.learn.bootcamp.*;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("melhor curso para sair do zero em Java.");
        curso1.setCargaHoraria(21);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso JS");
        curso2.setDescricao("pior curso de todos, mas temos que fazer por causa dos mimimi.");
        curso2.setCargaHoraria(1);

        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("Mentoria de Java");
        mentoria1.setDescricao("Se prepare para entender alguns padrões para o seu código Java.");
        mentoria1.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp("Bootcamp Java Developer", "Aprenda a ser um main Java Developer!");
        bootcamp.adicionarConteudo(curso1);
        bootcamp.adicionarConteudo(curso2);
        bootcamp.adicionarConteudo(mentoria1);

        Dev dev1 = new Dev();
        dev1.setNome("Camila");
        dev1.inscreverBootcamp(bootcamp);

        System.out.println(bootcamp);

    }

}