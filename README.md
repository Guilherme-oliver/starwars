## Star Wars API

## ♦ Descrição:
A Star Wars API é uma aplicação RESTful desenvolvida com Java 17 e Spring Boot 3. Esta API permite gerenciar informações sobre planetas do universo Star Wars, incluindo nome, clima, terreno e a quantidade de aparições em filmes. As informações sobre as aparições em filmes são obtidas da API pública do Star Wars (SWAPI).

## ♦ Funcionalidades:
Adicionar um planeta: Permite adicionar um novo planeta com nome, clima e terreno.
Listar planetas: Retorna a lista de todos os planetas cadastrados.
Buscar por nome: Permite buscar um planeta pelo nome.
Buscar por ID: Permite buscar um planeta pelo ID.
Remover planeta: Permite remover um planeta pelo ID.

## ♦ Tecnologias Utilizadas:

• Java 17

• Spring Boot 3

• PostgreSQL

• Docker

• Lombok

• SWAPI (Star Wars API)

• Swagger (OpenAPI 3)

• Git

• Postman

## ♦ Pré-requisitos:

• Docker

• Docker Compose

• Java 17

• Maven

• GitBash

## ♦ Configuração do Ambiente:

• Docker

1. Crie um arquivo docker-compose.yml com o seguinte conteúdo:

```version: '3.9'

services:
  postgres:
    image: postgres:14-alpine
    ports:
      - 5432:5432
    volumes:
      - ~/apps/postgres:/var/lib/postgresql/data
    environment:
      - POSTGRES_DB=db-star-wars
      - POSTGRES_USER=postgres
      - POSTGRES_PASSWORD=123456
```
      
2. Inicie o serviço PostgreSQL com Docker Compose:
```
docker-compose up -d
```

## ♦ Configuração da Aplicação:

1. No arquivo src/main/resources/application.yml, configure as informações do banco de dados e da SWAPI:
```
spring:
  application:
    name: star-wars
  datasource:
    url: jdbc:postgresql://localhost:5432/db-star-wars
    username: postgres
    password: 123456
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect

swapi:
  base:
    url: https://swapi.dev/api
```
## ♦ Execução

1. Clone o repositório:
```
git@github.com:Guilherme-oliver/starwars.git
```
2. Compile e execute a aplicação:
```
./mvnw clean install
./mvnw spring-boot:run
```

3. Acesse a aplicação em http://localhost:8080.

## ♦ Endpoints da API

Adicionar um Planeta:

POST /planetas
```
{
  "name": "Tatooine",
  "climate": "arid",
  "terrain": "desert"
}
```
Listar Planetas:

GET /planetas

Buscar Planeta por Nome:

GET /planetas/{findByName}/findByName

Buscar Planeta por ID:

GET /planetas/{id}

Remover Planeta:

DELETE /planetas/{id}

## ♦ Documentação da API:

A documentação da API está disponível no Swagger, que pode ser acessado em http://localhost:8080/swagger-ui.html.

## ♦ Contribuição

Faça um fork do projeto
Crie uma branch para sua feature (git checkout -b feature/example)
Commit suas alterações (git commit -m 'Add some example')
Faça o push para a branch (git push origin feature/example)
Abra um Pull Request

## ♦ Licença:
Este projeto está licenciado sob a Licença Apache 2.0 - veja o arquivo LICENSE para mais detalhes.

## ♦ Desenvolvido por Guilherme Rodrigues de Oliveira
