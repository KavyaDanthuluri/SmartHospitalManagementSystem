# Smart Hospital Management System

A RESTful backend application developed using **Java** and **Spring Boot** to simplify hospital operations such as patient management,department management, doctor management, appointment scheduling, prescription generation, and billing.

This project follows a layered architecture with DTO-based request/response handling, validation, exception handling, and PostgreSQL integration.

---

## Features

- Doctor Management
  - Add, update, view, and delete doctors
  - Manage doctor specialization and experience

- Patient Management
  - Register new patients
  - Update patient details
  - View and delete patient records

- Appointment Management
  - Schedule appointments
  - Update appointment status
  - View appointment details

-  Prescription Management
  - Generate prescriptions
  - Store diagnosis
  - Add medicines and instructions

- Billing Management
  - Generate patient bills
  - Store payment method
  - Track payment status

- Department Management
  - Add, update, view, and delete department

- Input Validation
  - Field-level validation using Jakarta Bean Validation

- Global Exception Handling
  - Centralized exception handling using `@RestControllerAdvice`

- DTO Mapping
  - Separate Request and Response DTOs
  - Prevent direct exposure of entity classes

---

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA (Hibernate)
- PostgreSQL
- pgAdmin
- Maven
- REST APIs
- Jakarta Bean Validation
- Postman
- Git & GitHub

---

## Project Structure

```
src/main/java
│
├── controller
├── dto
├── entity
├── enums
├── exception
├── repository
├── service
└── utility
```

---

## Database

- PostgreSQL
- Managed using pgAdmin
- Entity relationships implemented using JPA/Hibernate

---

## Modules

- Doctor
- Patient
- Appointment
- Prescription
- Billing
- Department

---

## API Workflow

```
Client
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
PostgreSQL
```

---

## API Testing

All REST APIs have been tested using **Postman**.

Operations implemented:
- Create
- Update
- Get by ID
- Get All
- Delete

---

## Exception Handling

Implemented custom exception handling for:

- Resource Not Found
- Invalid Data
- Validation Errors
- Duplicate Records

---

## Future Enhancements

- Spring Security
- JWT Authentication
- Role-Based Authorization
- Swagger/OpenAPI Documentation
---

## Developer

**Kavya**

Java Backend Developer

GitHub: https://github.com/KavyaDanthuluri

---

## Project Status

- Completed Core Backend Modules

- Security (Spring Security + JWT) – In Progress
