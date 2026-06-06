# 💳 Sistema Bancário API

API REST desenvolvida com Java 21 e Spring Boot para gerenciamento de contas bancárias e transferências entre contas.

O projeto simula operações bancárias reais, aplicando regras de negócio, persistência de dados com PostgreSQL, autenticação via JWT, documentação com Swagger/OpenAPI e tratamento global de exceções.

---

## 🚀 Tecnologias Utilizadas

- Java 21 (LTS)
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- Hibernate
- PostgreSQL
- JWT (JSON Web Token)
- Swagger/OpenAPI (SpringDoc)
- Bean Validation
- Maven
- Lombok

---

## 📋 Funcionalidades

### Contas Bancárias

- Criar conta bancária
- Buscar conta por ID
- Listar todas as contas
- Consultar saldo
- Bloquear conta
- Listar contas bloqueadas

### Transferências

- Transferir saldo entre contas
- Impedir transferência para a mesma conta
- Impedir transferências com valor inválido
- Impedir transferências com saldo insuficiente
- Impedir operações em contas bloqueadas
- Registrar histórico de transações

### Segurança

- Autenticação com JWT
- Proteção de endpoints com Spring Security
- Geração de token de acesso
- Validação automática de tokens em requisições autenticadas

### Tratamento de Erros

- Conta não encontrada
- Conta já bloqueada
- Saldo insuficiente
- Valor de transferência inválido
- Transferência para a mesma conta
- Validação de dados de entrada

---

## 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

### Controller

Responsável por receber as requisições HTTP e retornar respostas ao cliente.

### Service

Contém toda a lógica de negócio da aplicação.

### Repository

Responsável pela comunicação com o banco de dados através do Spring Data JPA.

### DTO

Utilizados para validação e transporte de dados entre cliente e API.

### Exception Handler

Centraliza o tratamento de erros da aplicação utilizando `@RestControllerAdvice`.

---

## 📂 Estrutura do Projeto

```text
src
 └── main
      ├── controller
      ├── service
      ├── security
      ├── repository
      ├── entity
      ├── dto
      ├── config
      ├── mapper
      ├── exception
      │     └── handler
      └── resources
```

---

## 🔐 Autenticação JWT

A API utiliza autenticação baseada em JSON Web Token (JWT).

### Login

```http
POST /auth/login
```

#### Exemplo

```text
username=admin
password=123
```

#### Resposta

```text
eyJhbGciOiJIUzI1NiJ9...
```

### Utilizando o Token

Após obter o token, envie-o no header Authorization:

```http
Authorization: Bearer SEU_TOKEN
```

Todos os endpoints da API, exceto os de autenticação e documentação, exigem um token JWT válido.

---

## 📚 Documentação da API

A documentação interativa está disponível através do Swagger UI.

Após iniciar a aplicação, acesse:

```text
http://localhost:8080/swagger-ui/index.html
```

O Swagger permite:

- Visualizar todos os endpoints
- Testar requisições diretamente pelo navegador
- Consultar exemplos de requests e responses
- Autenticar utilizando JWT através do botão "Authorize"

---

## 📌 Endpoints

### Login

```http
POST /auth/login
```

### Criar Conta

```http
POST /accounts
```

#### Request

```json
{
  "name": "João",
  "accountNumber": "10001",
  "balance": 1000.00
}
```

#### Response

```json
{
  "id": 1,
  "name": "João",
  "accountNumber": "10001",
  "balance": 1000.00,
  "blocked": false
}
```

### Buscar Conta por ID

```http
GET /accounts/{id}
```

### Listar Todas as Contas

```http
GET /accounts
```

### Consultar Saldo

```http
GET /accounts/{id}/balance
```

### Bloquear Conta

```http
PATCH /accounts/{id}/block
```

### Listar Contas Bloqueadas

```http
GET /accounts/status/blocked
```

### Transferência

```http
POST /accounts/transfer
```

#### Request

```json
{
  "sourceAccount": 1,
  "destinationAccount": 2,
  "value": 100.00
}
```

---

## ⚠️ Exemplo de Tratamento de Erros

### Conta não encontrada

```json
{
  "message": "Account not found",
  "status": 404,
  "timestamp": "2026-06-01T21:30:00"
}
```

### Saldo insuficiente

```json
{
  "message": "No balance in account",
  "status": 400,
  "timestamp": "2026-06-01T21:30:00"
}
```

### Erro de validação

```json
{
  "message": "Balance is required",
  "status": 400,
  "timestamp": "2026-06-01T21:30:00"
}
```

---

## 🗄️ Banco de Dados

O projeto utiliza PostgreSQL.

Crie um banco chamado:

```sql
CREATE DATABASE sistema_bancario;
```

Configure suas credenciais no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/YOUR_DATABASE
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

jwt.secret=YOUR_JWT_SECRET
```

---

## ▶️ Como Executar o Projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/salingean/sistema-bancario.git
```

### 2. Entrar na pasta

```bash
cd sistema-bancario
```

### 3. Configurar o PostgreSQL

```sql
CREATE DATABASE sistema_bancario;
```

### 4. Configurar o application.properties

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/YOUR_DATABASE
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

jwt.secret=YOUR_JWT_SECRET
```

### 5. Executar o projeto

```bash
mvn spring-boot:run
```

Ou execute diretamente pela sua IDE.

---

## 🎯 Conceitos Demonstrados

- Programação Orientada a Objetos (POO)
- APIs REST
- Spring Boot
- Spring Security
- JWT Authentication
- Injeção de Dependência
- Spring Data JPA
- Hibernate
- PostgreSQL
- Bean Validation
- DTO Pattern
- OpenAPI / Swagger
- Filtros de Segurança
- Tratamento Global de Exceções
- Transações com `@Transactional`
- Arquitetura em Camadas

---

## 👨‍💻 Autor

Desenvolvido por **Salin Gean** como projeto de estudo para aprofundamento em Java, Spring Boot, Spring Security, autenticação JWT e desenvolvimento de APIs REST.
