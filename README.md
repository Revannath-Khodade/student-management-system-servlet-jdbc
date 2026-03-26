# 🎓 Student Management System (Servlet + JDBC)

## 📌 Overview

This project is a **Student Management System** built using **Java Servlets and JDBC**.
It is a web-based application that allows users to perform **CRUD operations** (Create, Read, Update, Delete) on student data stored in a MySQL database.

---

## 🚀 Features

* ➕ Add Student
* 📋 View Students
* ✏️ Edit Student
* 🗑️ Delete Student
* 💾 Data stored in MySQL database
* 🎨 Clean and simple UI using HTML & CSS

---

## 🛠️ Tech Stack

* **Java**
* **Servlet (Jakarta EE)**
* **JDBC**
* **MySQL**
* **HTML5 / CSS3**
* **Apache Tomcat**

---

## 🧱 Project Architecture

This project follows a basic **MVC (Model-View-Controller)** pattern:

* **Model** → Database (MySQL)
* **View** → HTML / JSP pages
* **Controller** → Java Servlets

---

## 🔄 Application Flow

1. User submits form data from the browser
2. Request is sent to the Servlet
3. Servlet processes the request
4. JDBC connects to MySQL database
5. Data is stored/retrieved from DB
6. Response is sent back to the browser

---

## 📂 Project Structure

```
src/main/java
 └── com.student.servlet
      ├── AddStudentServlet.java
      ├── ViewStudentsServlet.java
      ├── UpdateStudentServlet.java
      ├── DeleteStudentServlet.java
      ├── EditStudentServlet.java
      └── DBConnection.java

src/main/webapp
 ├── index.jsp
 ├── style.css
 └── WEB-INF
```

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the repository

```
git clone https://github.com/Revannath-Khodade/student-management-system-servlet-jdbc.git
```

### 2️⃣ Import project into Eclipse

* File → Import → Existing Maven Project

### 3️⃣ Configure Apache Tomcat Server

* Add server in Eclipse
* Deploy project

### 4️⃣ Setup MySQL Database

```sql
CREATE DATABASE student_db;

USE student_db;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100)
);
```

### 5️⃣ Update Database Credentials

⚠️ Do NOT hardcode passwords
Use environment variable:

```
DB_PASSWORD=your_password
```

---

## 🔐 Security Note

Database credentials are handled using **environment variables** to avoid exposing sensitive data.

---

## 📸 Screenshots

(Add screenshots here if needed)

---

## 🎯 Learning Outcomes

* Understanding of Java Servlets lifecycle
* JDBC database connectivity
* CRUD operations implementation
* MVC architecture basics
* Web application development using Java

---

## 👨‍💻 Author

**Revan**

---

## ⭐ If you like this project

Give it a ⭐ on GitHub!
