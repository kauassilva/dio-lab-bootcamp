# DIO Lab - Sistema de Bootcamp

Este projeto é um sistema de gerenciamento de aprendizado que permite aos desenvolvedores se inscreverem em bootcamps e progredirem através de diferentes conteúdos de aprendizado. Os conteúdos de aprendizado podem ser cursos ou mentorias.

## Principais Novas Funcionalidades/Modificações 

Comparado à versão anterior (original da DIO), a nova versão do projeto introduziu várias melhorias e novas funcionalidades:

1. **Certificados**: Agora, quando um desenvolvedor conclui um conteúdo ou bootcamp, um certificado é gerado. Isso é representado pela nova classe `Certificado` e pelo novo método `gerarCertificado()` na classes `Bootcamp` e `Conteudo` (e as classes que extendem `Conteudo`).

2. **Tipos de Certificado**: Foi introduzido um novo enum `TipoCertificado` para representar os diferentes tipos de certificados que podem ser gerados (`CURSO`, `MENTORIA` e `BOOTCAMP`).

3. **Nível**: foi introduzido um novo enum `Nivel` para representar a dificuldade (`BASICO`, `INTERMEDIARIO`, `AVANCADO`) dos cursos, mentorias e do bootcamp.

4. **Desistência de Bootcamps**: Os desenvolvedores agora podem desistir de um bootcamp, o que remove o bootcamp da lista de bootcamps inscritos, e todos os conteúdos desse bootcamp da lista de conteúdos inscritos do desenvolvedor.

5. **Melhorias na Classe Conteudo**: A classe `Conteudo` agora inclui mais campos e métodos. Todo `Conteudo` tem um título, descrição, carga horária e nível.
