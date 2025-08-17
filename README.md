Different commits mean different things : 
feature : This is a new feature which is introduced
bugfix : Bug fixes in the current feature 
refactor : refactor the code for existing features


FEATURES I AM GONNA TARGET : 
Project Scope (Backend-Focused E-Commerce Order Management System)
1. Core Features

API Endpoints

User Service: signup, login, profile

Product Service: add/list/update products

Order Service: create, view, cancel orders

Data Storage & Management

MySQL for relational data (users, orders, transactions)

MongoDB for flexible/non-relational data (product metadata, logs)

Caching with Redis for faster reads (e.g., product catalog, user sessions)

2. Cross-Cutting Concerns

Authentication & Authorization

JWT-based authentication

Role-based access control (admin, customer)

Performance Optimization

Database indexing

Redis caching

Asynchronous processing (via Kafka where needed)

Error Handling & Logging

Centralized error handler in each microservice

Structured logs (JSON) → could be viewed via ELK stack later

Security

Input validation and sanitization

Protect against SQL injection, XSS

Secure JWT handling and password hashing (BCrypt)

3. Advanced / Resume-Boosting Elements

Microservices Communication

REST for synchronous calls

Kafka for asynchronous events (e.g., when an order is placed → notify inventory service)

Containerization & Deployment

Dockerize all microservices

Use Docker Compose for local development

(Optional) Deploy simple Kubernetes manifests later

Scalability & Maintainability

Clear separation of services (User, Product, Order)

API gateway (Spring Cloud Gateway or simple NGINX) for routing requests
