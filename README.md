# MicroservicesSpringBoot

A small project to ilustrate the microservices architecture using Spring Boot.

Architecture:

-> Student Microservice + Postgres DB on Docker
-> School Microservice + Postgres DB on Docker
-> A Gateway Microservice to intercept the requests

![image](https://github.com/user-attachments/assets/39710646-897f-48b1-a8b9-1e299e656c2c)


API Gateway
The API Gateway serves as the single entry point for all client requests, managing and routing them to the appropriate microservices.

Config Server
The Config Server centralizes configuration management for all microservices, simplifying application maintenance and consistency across environments.

Discovery Server
The Discovery Server provides service registration and discovery, enabling seamless service-to-service communication within the microservices ecosystem.

Student Microservice
The Student Microservice is responsible for managing student-related data and operations, such as adding, updating, and retrieving student records.

School Microservice
The School Microservice manages school-related data and operations, including adding, updating, and retrieving school records.

