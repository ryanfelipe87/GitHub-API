# GitHub API Test

Realiza buscas de repositórios do GitHub através do username, utilizando da api pública do GitHub, desenvolvido como parte do processo seletivo na empresa SelectBR.

## Instruções de execução da aplicação

1. Baixe o projeto: 'git clone https://github.com/ryanfelipe87/GitHub-API.git'
2. Abra o terminal e navegue até a pasta do projeto.
3. Execute o seguinte comando no terminal: 'mvn clean package'
4. Inicialize a aplicação com o comando: 'java -jar target/github-0.0.1-SNAPSHOT.jar'
5. Abra o Swagger no navegador através do link: 'http://localhost:8081/swagger-ui/index.html'

Observações:
- A porta em que a aplicação está rodando é a '8081', neste caso quando for utilizar o Swagger no navegador, trocar a porta.

**Tecnologias utilizadas:**
- Java 17
- Spring Boot 3.1.5
- JUnit 5 para testes unitários
- Insomnia para testar a API REST
- Git para versionamento de código e GitHub para hospedagem do projeto 