# **Java Machine Test - Nimap Task**

## **Project Overview**
This project is a Spring Boot-based REST API that manages **Categories** and **Products**. The APIs include **CRUD operations** for both entities, along with **pagination** and a **one-to-many relationship** between Categories and Products. The backend is built with **MySQL** as the database and follows annotation-based configuration using **JPA & Hibernate**.

---

## **Features Implemented**
1. **Category CRUD Operations**  
   - Create, Read, Update, and Delete categories.

2. **Product CRUD Operations**  
   - Create, Read, Update, and Delete products.

3. **Pagination**  
   - Integrated pagination for listing categories and products.

4. **Relationship Mapping**  
   - One-to-Many relationship:  
     - One category can contain multiple products.

---

## **API Endpoints**

### **Category API Endpoints**
| HTTP Method | Endpoint                     | Description                       |
|-------------|------------------------------|-----------------------------------|
| GET         | `/api/categories?page={n}`   | Get all categories (paginated).  |
| POST        | `/api/categories`            | Create a new category.           |
| GET         | `/api/categories/{id}`       | Get category by ID.              |
| PUT         | `/api/categories/{id}`       | Update category by ID.           |
| DELETE      | `/api/categories/{id}`       | Delete category by ID.           |

### **Product API Endpoints**
| HTTP Method | Endpoint                     | Description                      |
|-------------|------------------------------|----------------------------------|
| GET         | `/api/products?page={n}`     | Get all products (paginated).    |
| POST        | `/api/products`              | Create a new product.            |
| GET         | `/api/products/{id}`         | Get product by ID.               |
| PUT         | `/api/products/{id}`         | Update product by ID.            |
| DELETE      | `/api/products/{id}`         | Delete product by ID.            |

---

## **Technologies Used**
- **Java 17**  
- **Spring Boot**  
- **Spring Data JPA & Hibernate**  
- **MySQL** (Database)  
- **Maven** (Build tool)  
- **Lombok** (For reducing boilerplate code)

---

## **Setup Instructions**

### **1. Prerequisites**
- **Java 17** or higher installed  
- **MySQL** installed and running  
- **Maven** installed  

### **2. Database Configuration**
Create a MySQL database named `machine-test` (or any name you prefer). Update the database credentials in the **`application.properties`** file.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/machine-test
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
