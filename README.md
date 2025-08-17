Different commits mean different things : 
feature : This is a new feature which is introduced
bugfix : Bug fixes in the current feature 
refactor : refactor the code for existing features


FEATURES I AM GONNA TARGET : 

# E-Commerce Order Management System - Project Checklist ✅

## Core Features
- [ ] API Endpoints  
  - [ ] Create Order  
  - [ ] Update Order  
  - [ ] Cancel Order  
  - [ ] Get Order Details  
  - [ ] List All Orders  

- [ ] Data Storage and Management  
  - [ ] SQL Database (e.g., MySQL/PostgreSQL) for structured data (orders, payments, users)  
  - [ ] NoSQL Database (e.g., MongoDB) for product catalog and logs  
  - [ ] Database schema design and indexing  

- [ ] Authentication and Authorization  
  - [ ] JWT-based Authentication  
  - [ ] Role-based Access Control (Admin, Customer)  
  - [ ] User Registration & Login  

## Performance Optimization
- [ ] Implement caching (e.g., Redis) for frequently accessed data  
- [ ] Optimize database queries (indexes, pagination)  
- [ ] Asynchronous processing for long-running tasks  

## Error Handling & Logging
- [ ] Centralized error handling (Global Exception Handler)  
- [ ] Logging (e.g., SLF4J + Logback)  
- [ ] Store logs in NoSQL (MongoDB/Elasticsearch)  

## Security
- [ ] Input validation (sanitize user input)  
- [ ] Protect against SQL injection  
- [ ] Secure headers and HTTPS enforcement  
- [ ] Rate limiting for APIs  

## Advanced Features (to stand out 🚀)
- [ ] Microservices Communication  
  - [ ] REST → Kafka → REST workflow  
  - [ ] Event-driven order status updates  

- [ ] Containerization & Deployment  
  - [ ] Dockerize each microservice  
  - [ ] Use Docker Compose for local development  
  - [ ] Kubernetes basics (deploy services to a cluster)  
