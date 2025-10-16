# BankManagementSystemUpstream

# 🏦 Bank Management System

A **Spring MVC**-based web application designed to manage core banking operations such as customer registration, account management, transactions, and balance inquiries.  
This project uses **Hibernate (JPA)** for ORM, **MySQL** as the database, and **HTML/CSS** for the frontend.

---

## 🚀 Features

- 👤 **Customer Management** – Add, view, update, and delete customer details.  
- 💰 **Account Management** – Create and manage savings/current accounts.  
- 🔁 **Transactions** – Perform deposits, withdrawals, and fund transfers.  
- 📊 **Balance Inquiry** – View available balance and recent transaction history.  
- 🔐 **Authentication** – Simple login/logout for admin and customers.  
- 🖥️ **User Interface** – Clean and responsive frontend built using HTML & CSS.

---

## 🧰 Tech Stack

| Layer | Technology |
|--------|-------------|
| Backend | Spring MVC, Hibernate (JPA) |
| Database | MySQL |
| Frontend | HTML, CSS |
| Build Tool | Maven |
| Server | Apache Tomcat |

---

## 🗄️ Database Configuration

1. Create a database named `bank_db` in MySQL.  
2. Update the database credentials in `src/main/resources/hibernate.cfg.xml` (or `application.properties` if used):

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bank_db
spring.datasource.username=root
spring.datasource.password=yourpassword
hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
hibernate.hbm2ddl.auto=update
