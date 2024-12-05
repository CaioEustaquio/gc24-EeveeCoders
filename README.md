# **Projeto Final - Eevee Coders**

## **Equipe**
- **Caio Eustáquio**
- **Érika Fedrigo**
- **Lisiane Hoffmeister**
- **Matheus Borges de Toledo Guerra**
- **Pablo Gascón**

## **Objetivo do Projeto**
Criar uma **plataforma centralizada para fãs da franquia *The Legend of Zelda***, permitindo:
- **Busca personalizada**: Pesquise por jogos específicos da série.
- **Favoritos**: Adicione jogos à sua lista pessoal de favoritos para acessá-los facilmente.
- **Cadastro de usuários**: Uma experiência personalizada para cada entusiasta.

Essa plataforma tem como foco ser um **MVP (Produto Mínimo Viável)**, utilizando uma **arquitetura de microserviços**, que facilita a manutenção e a escalabilidade no futuro.

---

## **Tecnologias Utilizadas**
- **Spring Boot**: Framework principal para o desenvolvimento da API.
- **PostgreSQL**: Banco de dados relacional para armazenamento de informações.
- **Maven**: Gerenciamento de dependências.
- **Lombok**: Redução de boilerplate no código Java.
- **Java JDK 21**: Ambiente de desenvolvimento.
- **Swagger**: Para documentação da API.
- **Postman**: Testes e consumo de endpoints.
- **JUnit**: Testes unitários para garantir a qualidade do código.

---

## **Estrutura do Projeto**
O software foi desenvolvido em **três microserviços distintos**, cada um com responsabilidades claras:
1. **User Api**: Gerencia o cadastro e autenticação de usuários.
2. **Zelda Api**: Centraliza as informações sobre os jogos da franquia Zelda.

Essa divisão em microserviços permite **melhor organização**, **fácil manutenção** e **escalabilidade**, tornando o sistema robusto e preparado para crescimento.

---

## **Instruções de Configuração**
1. **Configuração de Variáveis de Ambiente**:
    - O projeto utiliza variáveis de ambiente para maior segurança. Certifique-se de configurar as seguintes:
        - `DB_URL`: URL do banco de dados.
        - `DB_USERNAME`: Nome de usuário do banco de dados.
        - `DB_PASSWORD`: Senha do banco de dados.

2. **Banco de Dados**:
    - Instale e configure o **PostgreSQL** no seu computador.
    - Crie um banco de dados para o projeto e configure as credenciais corretamente nas variáveis de ambiente.

---

## **Como Executar o Projeto**
1. **Pré-requisitos**:
    - Certifique-se de ter o **IntelliJ IDEA** (ou outro IDE de sua preferência) instalado.
    - Garanta que o **JDK 21** está configurado corretamente no ambiente.

2. **Passos para execução**:
    - Clone o repositório do projeto para o seu computador.
    - No IntelliJ, importe o projeto como um projeto Maven.
    - Certifique-se de que as dependências foram baixadas com sucesso.
    - Localize o arquivo principal do projeto:
      ```
      src/main/java/com/suaempresa/UserApiProjetoFinalApplication
      ```
    - Execute a aplicação diretamente da IDE ou via linha de comando com:
      ```
      mvn spring-boot:run
      ```

---

## **Testando a API**
1. **Swagger UI**:
    - Acesse a documentação interativa gerada pelo Swagger após iniciar o projeto em:
      ```
      http://localhost:8080/swagger-ui.html
      ```

2. **Postman**:
    - Importe o arquivo de configuração do Postman (se disponível) para testar os endpoints diretamente.

---
