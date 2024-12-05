# User-API para Boss-3 da Geração Caldeira
Este projeto seria um micrserviço parte do Boss que é encarregado de receber requisições API para criar, deletar, atualizar e recuperar usuários do sistema por meio de um Banco de Dados.
## Tecnologías
- Java 21
- Maven
- Spring Boot
- PostgreSQL
# Como Usar
## Requerimentos
- Instância funcionando de [PostgreSQL](https://www.postgresql.org)
- JDK 21, disponível no site da [Oracle](https://www.oracle.com/java/technologies/downloads/)
- Editor de código (IDE) com função para rodar programas em Java, [IntelliJ Community](https://www.jetbrains.com/idea/download/) recomendado
- [Git](https://git-scm.com/downloads) para clonar o repositório
## Instalação
Primeiro clone o repositório usando git, para isso abra o terminal, CMD no Windows, Terminal no MacOS ou bash em Linux. Vá ate o diretório no terminal onde deseja clonar e digite `git clone https://github.com/CaioEustaquio/gc24-EeveeCoders.git`.

Crie um Banco de Dados com o postgreSQL, seguindo [essas instruções](https://www.postgresql.org/docs/current/manage-ag-createdb.html) ou usando algum gerenciador de banco de dados como pgadmin4 ou DBeaver. Depois de criar o banco va ate a pasta mãe do user-api e crie um novo arquivo vazio só chamado `.env` e nele coloque os campos que se encontram no arquivo `.env.example` que se encontra no mesmo diretório. No campo `DB_CONNECTION_STRING=` coloque o endereço onde se encontra o banco, seguindo esse padrão: `jdbc:postgresql://<endereço-web>:<porta>/<nome-do-banco>`; em `DB_USERNAME=` escreva um usuario do Postgre que tenha acesso ao banco, e `DB_PASSWORD=` a senha desse usuario.

Para montar o programa simplesmente com seu IDE rode o arquivo `UserApiProjetoFinalApplication.java` em `/user/src/java/com.caldeira.projetofinal/`.
## Uso
Para recuperar todos os usuários registrados no banco de dados mande uma requisição GET para `<endereço_do_banco>/users/all`, para recuperar um usuário específico utilize GET em `<endereço_do_banco>/users/get-by-id/<id_do_usuario_que_quiser_recuperar>`.

Para registrar novo usuário envie requisição POST em `<endereço_do_banco>/users/create`, contendo um arquivo JSON listando os campos `first_name` tendo como valor o primeiro nome e `last_name` com valor sendo seu último nome.

Para deletar um usuário existente seria requisição DELETE em `<endereço_do_banco>/users/delete/<id_a_ser_deletado>`

Para atualizar um usuário, PUT em `<endereço_do_banco>/users/update/<id_a_ser_atualizado>` tendo um arquivo JSON com os mesmos campos da requisição POST mas com os valores atualizados
