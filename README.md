# Customer

Este é um projeto que visa o desenvolvimento de uma API Restful, de um cadastro de cliente para a disciplina Implantação de Software.
Contendo as seguintes tecnologias para desenvolvimento:

  - Java 1.8
  - Maven 4.0.0
  - Spring Boot 2.0.5
  - PostgreSQL
  - Liquibase-core
  - Docker
  - Docker Compose

O projeto utiliza um banco PostgreSQL de teste e para profile de desevolvimento, apesar de que outros bancos podem ser configurados facilmente.

O banco PostgreSQL esta configurado no Docker Compose, mas também pode ser instalado através do link oficial [PostgreSQL](https://www.postgresql.org/download/linux/)
e configurado manualmente.

## 1. Requisitos e Configurações

Para executar o projeto é necessária a instalação das seguintes ferramentas:

    1. JDK 1.8
    2. Maven 4.0.0
    3. Docker
    4. Docker Compose
    5. PostgreSQL
    
  - [Download JDK 1.8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
  - [Download Docker](https://docs.docker.com/install/linux/docker-ce/ubuntu/)
  - [Download Docker Compose](https://docs.docker.com/compose/install/)

## 2. Executando o Projeto

Iniciar o Docker Compose para subir o banco de dados relacional (PostgreSQL), dentro da pasta raiz do projeto, através do seguinte comando:

```sh
$ docker-compose up
```

Para encerrar o banco de dados relacional (PostgreSQL), dentro da pasta raiz do projeto, utilize o seguinte comando:

```sh
$ docker-compose down
```

Após baixar o projeto, e as ferramentas necessárias, para executá-lo é necessário rodar os seguintes comandos dentro da pasta raiz do projeto.

```sh
$ maven clean build
$ mvn spring-boot:run
```
