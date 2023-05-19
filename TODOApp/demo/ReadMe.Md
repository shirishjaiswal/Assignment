# **About Assignment**
## **Name :-** TODO
## **Framework :-** Spring
**Language :-** Java
---
## **Data Flow**
### **Controller Package**
This Package Handles the HTTP Request from the client.
It contains only **One** classes
1. TodoController

These Controller have mainly CRUD Operation Request
@GetMapping:
The @GetMapping annotation is used to map HTTP GET requests to a specific method in the controller class.
It is used to retrieve or fetch data from the server.
It can be applied to a class or a specific method.
In the example, @GetMapping is used on the getAllStudents method to map a GET request to the /api/students endpoint, which retrieves a list of all students.
1. **@PostMapping:**
    1. The @PostMapping annotation is used to map HTTP POST requests to a specific method in the controller class.
    2. It is used to submit or create new data on the server.
    3. It can be applied to a class or a specific method.
2. **@PutMapping:**
    1. The @PutMapping annotation is used to map HTTP PUT requests to a specific method in the controller class.
    2. It is used to update or modify existing data on the server.
    3. It can be applied to a class or a specific method.
3. **@DeleteMapping:**
    1. The @DeleteMapping annotation is used to map HTTP DELETE requests to a specific method in the controller class.
    2. It is used to delete or remove data from the server.
    3. 1.It can be applied to a class or a specific method.
___
### **Service Package**
This is a Java Spring Boot service class that contains methods for performing CRUD (Create, Read, Update, Delete) operations on job objects. It is annotated with **@Service**, which is a Spring stereotype annotation indicating that this class is a service.
This package also consist of Four classes and One Interface.
1. TodoService
___
### **Repository Package**
This package consist of interfaces. Which defines a set of methods that can be used to interact with the underlying database. The interface extends the JpaRepository interface and specifies the Job entity and the data type of its primary key Integer.
The interface contains several custom finder methods that use the naming convention of Spring Data JPA to automatically generate the queries.
In summary, this code implements a simple REST ful API for managing Job objects with endpoints for performing CRUD operations.
1. TodoDao
___
### **Model package**
Model package Consist of Five Classes and One Enum
1. Todo

All below annotations are applied on each class above:
1. **@Entity:** Indicates that this class is a JPA entity and should be mapped to a database table.
2. **@Table:** Specifies the name of the database table to which this entity is mapped.
3. **@Id:** Indicates that the id field is the primary key of the entity.
4. **@GeneratedValue:** Specifies the strategy for generating values for the primary key. In this case, it uses GenerationType.AUTO.
___
