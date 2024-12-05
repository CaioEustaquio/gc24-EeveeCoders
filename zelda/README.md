# User-API para Boss-3 da Geração Caldeira
Este projeto seria um micrserviço parte do Boss que é encarregado de receber requisições API para criar, deletar, atualizar e recuperar usuários do sistema por meio de um Banco de Dados.
## Tecnologías
- Java 21
- Maven
- Spring Boot
- Spring Boot
- Fan APIs - Zelda
# Como Usar
## Requerimentos
- JDK 21, disponível no site da [Oracle](https://www.oracle.com/java/technologies/downloads/)
- Editor de código (IDE) com função para rodar programas em Java, [IntelliJ Community](https://www.jetbrains.com/idea/download/) recomendado
- [Git](https://git-scm.com/downloads) para clonar o repositório
## Instalação
Primeiro clone o repositório usando git, para isso abra o terminal, CMD no Windows, Terminal no MacOS ou bash em Linux. Vá ate o diretório no terminal onde deseja clonar e digite `git clone https://github.com/CaioEustaquio/gc24-EeveeCoders.git`.

Para montar o programa simplesmente com seu IDE rode o arquivo `ZeldaApiProjetoFinalApplication.java` em `/zelda/src/java/com.caldeira.projetofinal/`.
## Uso
Para recuperar todos os jogos registrados na API mande uma requisição GET para `http://localhost:8082/zelda/get-all`, este endpoint irá retorna a lista de jogos.

Para recuperar um jogo específico pelo ID envie uma requisição GET para `http://localhost:8082/zelda/get-by-id/{id}}`, este endpoint irá retornar apenas o jogo no qual o id foi especificado.

Para recuperar um jogo específico pelo nome envie uma requisição GET para `http://localhost:8082/zelda/get-by-name/{nome_do_jogo}}`, este endpoint irá retornar um ou mais jogos onde a descrição seja parecida com o nome de jogo que foi enviado.
