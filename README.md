# Ostad Java SpringBoot 3 - Module 11 Assignment

Personal Finance Tracker (Transaction Management API)

A small Spring Boot application that demonstrates building a RESTful API to manage personal financial transactions using an in-memory list and the Java Stream API.

**Author:** Raisul Islam Niloy

**Date:** February 12, 2026

---

## 📋 Project Overview

This project is part of the **Ostad Java & SpringBoot 3 Backend Web Development** course (Module 11). The goal is to implement a Transaction Management API that supports basic CRUD operations on transactions stored in memory.

The app intentionally uses a simple in-memory List to keep the focus on REST controllers, service-layer design, and the Java Stream API for filtering and lookups.

---

## 🎯 Assignment Goal

Build a RESTful API for managing personal financial transactions with the following basic operations:

- GET    `/api/transactions`           — Get all transaction history
- GET    `/api/transactions/{id}`      — Get a specific transaction by id
- POST   `/api/transactions`           — Add a new transaction
- DELETE `/api/transactions/{id}`      — Delete a transaction by id

Optional (advanced):
- GET `/api/transactions?type=income|expense` — Filter transactions by type

Additionally, the application exposes a root endpoint `/` that returns a short welcome message.

---

## 🛠 Technology Stack

- Java 21
- Spring Boot 4.0.2 (spring-boot-starter-parent)
- spring-boot-starter-webmvc
- Maven (use included wrapper)

---

## 📁 Project Structure (key files)

```
Ostad_Java_SpringBoot_3_Module_11_Assignment/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/module_10_assignment/
│   │   │       ├── FinanceApplication.java          (Main entry point)
│   │   │       └── finance/
│   │   │           ├── contoller/
│   │   │           │   └── TransactionController.java
│   │   │           └── service/
│   │   │               └── TransactionService.java
│   │   │           └── model/
│   │   │               └── Transaction.java
│   │   └── resources/
│   │       └── application.properties
├── pom.xml
├── mvnw / mvnw.cmd
└── README.md
```

---

## 🚀 Getting Started

### Prerequisites

- JDK 21 or higher
- Optional: Git (to clone), but you can also copy the project folder

### Build

Open a terminal in the project root (Windows example shown):

```bash
mvnw.cmd clean package
```

### Run

Run with the Maven Spring Boot plugin (Windows):

```bash
mvnw.cmd spring-boot:run
```

Or run the built JAR:

```bash
java -jar target/Ostad_Java_SpringBoot_3_Module_11_Assignment-0.0.1-SNAPSHOT.jar
```

By default the app starts on: http://localhost:8080

---

## 🔌 API Endpoints

Base URL: `http://localhost:8080`

1) Root welcome

- GET `/`
- Response: plain text welcome message

Example:

GET http://localhost:8080/

Response body:
```
Welcome to Finacne appl;ication
```

2) Get all transactions

- GET `/api/transactions`
- Optional query param: `type` (e.g. `/api/transactions?type=income`)

Example:

GET http://localhost:8080/api/transactions

Response (JSON array):

```json
[
  {
    "id": 1,
    "type": "income",
    "amount": 1500.0,
    "description": "Salary"
  }
]
```

3) Get transaction by id

- GET `/api/transactions/{id}`

Example:

GET http://localhost:8080/api/transactions/1

Response (found):

```json
{
  "id": 1,
  "type": "income",
  "amount": 1500.0,
  "description": "Salary"
}
```

Response (not found): 404 Not Found

4) Add new transaction

- POST `/api/transactions`
- Content-Type: `application/json`
- Body (example):

```json
{
  "type": "expense",
  "amount": 45.5,
  "description": "Groceries"
}
```

Response (created): JSON of the created transaction with an auto-assigned `id` (the service sets `id` with an internal counter).

5) Delete transaction by id

- DELETE `/api/transactions/{id}`

Success response (HTTP 200):
```
Transaction with id 1 deleted successfully
```

Not found (HTTP 404):
```
Transaction with id 123 not found
```

---

## 📦 Data Model

Transaction JSON shape (class: `Transaction`):

```json
{
  "id": 1,               // Long (server assigned)
  "type": "income",    // String: "income" or "expense"
  "amount": 100.0,      // Double
  "description": "..." // String
}
```

The service uses a simple in-memory `List<Transaction>` and an incremental `currentId` (Long) to assign ids. Note: this is not persistent across restarts.

---
