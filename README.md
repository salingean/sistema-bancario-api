# 💳 Sistema Bancário API

API REST desenvolvida com Java e Spring Boot para gerenciamento de contas bancárias e transferências entre contas.

O projeto simula operações bancárias reais, aplicando regras de negócio, validações, tratamento global de exceções e persistência de dados com PostgreSQL.

---

## 🚀 Tecnologias Utilizadas

- Java 26
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- PostgreSQL
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
      ├── repository
      ├── entity
      ├── dto
      ├── exception
      │     └── handler
      └── resources
```

---

## 📌 Endpoints

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

---

### Buscar Conta por ID

```http
GET /accounts/{id}
```

---

### Listar Todas as Contas

```http
GET /accounts
```

---

### Consultar Saldo

```http
GET /accounts/{id}/balance
```

---

### Bloquear Conta

```http
PATCH /accounts/{id}/block
```

---

### Listar Contas Bloqueadas

```http
GET /accounts/status/blocked
```

---

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
spring.datasource.url=jdbc:postgresql://localhost:5432/sistema_bancario
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

---

## ▶️ Como Executar o Projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/SEU-USUARIO/sistema-bancario.git
```

### 2. Entrar na pasta

```bash
cd sistema-bancario
```

### 3. Configurar o PostgreSQL

Crie o banco:

```sql
CREATE DATABASE sistema_bancario;
```

Atualize as credenciais no arquivo:

```properties
application.properties
```

### 4. Executar o projeto

```bash
mvn spring-boot:run
```

ou execute diretamente pela sua IDE.

---

## 🎯 Conceitos Demonstrados

- Programação Orientada a Objetos (POO)
- APIs REST
- Spring Boot
- Injeção de Dependência
- Spring Data JPA
- Hibernate
- PostgreSQL
- Bean Validation
- DTO Pattern
- Tratamento Global de Exceções
- Transações com `@Transactional`
- Arquitetura em Camadas

---

## 👨‍💻 Autor

Desenvolvido por **Salin Gean** como projeto de estudo para aprofundamento em Java, Spring Boot e desenvolvimento de APIs REST.
