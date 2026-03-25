🚀 Spring Boot Employee Management System (with Security)
📌 Overview

This project is a Spring Boot REST API for managing employee data with Spring Security (Basic Auth) and Role-Based Authorization.

It supports full CRUD operations and filtering employees based on multiple attributes like salary, designation, age, etc.

🛠️ Tech Stack
Java 17+
Spring Boot
Spring Data JPA (Hibernate)
MySQL
Spring Security
Lombok
Maven
📂 Project Structure
com.Aadi
 ├── entity          → JPA Entities (Employee, User)
 ├── dto             → Data Transfer Objects
 ├── repo            → Repository Layer
 ├── service         → Service Interfaces
 ├── serviceImpl     → Business Logic
 ├── rest            → REST Controllers
 ├── security        → Security Configuration
 ├── exception       → Global Exception Handling
🔐 Security Features
Basic Authentication
Role-based access:
ADMIN
USER
🔑 Role Permissions
Endpoint	Access
Save Employee	ADMIN
Update Employee	ADMIN
Delete Employee	ADMIN
Get All Employees	USER
Get By ID	USER, ADMIN
Filter APIs	USER
⚙️ API Endpoints
🔸 Authentication
POST /auth/save-user
🔸 Employee APIs
➤ Create Employee
POST /api/v1/employee/save
➤ Get All Employees
GET /api/v1/employee/all
➤ Get Employee by ID
GET /api/v1/employee/get/{id}
➤ Update Employee
PUT /api/v1/employee/update/{id}
➤ Delete Employee
DELETE /api/v1/employee/delete/{id}
🔍 Filter APIs
GET /api/v1/employee/byfirstname?firstname=Rahul
GET /api/v1/employee/bydesignation?designation=Backend Developer
GET /api/v1/employee/byage?age=25
GET /api/v1/employee/byaddress?address=Pune
GET /api/v1/employee/bygender?gender=Male
GET /api/v1/employee/bysalary?salary=60000
🗄️ Database Configuration

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/20March
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
🧪 Sample User Creation
POST /auth/save-user

{
  "username": "Aadi",
  "password": "1234"
}

👉 Users Aadi and Raj → ADMIN
👉 Others → USER

▶️ How to Run
Clone repository
git clone https://github.com/your-username/your-repo-name.git
Open in IDE (IntelliJ / Eclipse)
Configure MySQL
Run application:
mvn spring-boot:run
Test APIs using Postman
⚠️ Important Notes
Follow camelCase naming for entity fields (e.g., salary, not Salary)
JPQL uses entity field names, not database column names
Ensure correct roles while accessing APIs
📌 Features

✔ CRUD Operations
✔ Role-Based Authentication
✔ Exception Handling
✔ DTO Pattern
✔ Clean Layered Architecture
