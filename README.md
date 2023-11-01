# GitHub API Test

Este projeto realiza buscas de repositórios do GitHub através do username, utilizando a API pública do GitHub. Foi desenvolvido como parte do processo seletivo na empresa SelectBR.

## Pré-requisitos
Antes de executar a aplicação, certifique-se de ter instalado em seu ambiente:

- Java 17
- Maven

## Instruções de execução da aplicação
1. Baixe o projeto: 'git clone https://github.com/ryanfelipe87/GitHub-API.git'
2. Abra o terminal e navegue até a pasta do projeto.
3. Execute o seguinte comando no terminal: 'mvn clean package'
4. Inicialize a aplicação com o comando: 'java -jar target/github-0.0.1-SNAPSHOT.jar'
5. Abra o Swagger no navegador através do link: 'http://localhost:8081/swagger-ui/index.html'

Observações:
-  A porta em que a aplicação está rodando é a '8081'. Caso necessário, ajuste a porta ao utilizar o Swagger no navegador.
- Este projeto pode ser executado em qualquer IDE de preferência para desenvolvimento de API com Spring.

## Tecnologias utilizadas
- Java 17
- Spring Boot 3.1.5
- JUnit 5 para testes unitários
- Insomnia para testar a API REST
- Git para versionamento de código e GitHub para hospedagem do projeto 