# **About Assignment**
## **Name :-** Instagram
## **Framework :-** Spring
**Language :-** Java
---
## **Data Flow**
### **Application Properties**
```
spring.datasource.driver-class-name = com.mysql.cj.jdbc.Driver
spring.datasource.url = jdbc:mysql://localhost:3306/Insta
spring.datasource.username = root
spring.datasource.password = root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.format_sql=true
```

### **Controller Package**
This Package Handles the HTTP Request from the client.
It contains the **Four** classes
1. AdminController
2. CommentController
3. PostController
4. UserController

These models have mainly CRUD Operation Request
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
This package also consist of **Eight** classes and One Interface.
1. AdminService
2. CommentService
3. FollowerService
4. FollowingService
5. LikeService
6. PostService
7. TokenService
8. UserService
___
### **Repository Package**
This package consist of interfaces. Which defines a set of methods that can be used to interact with the underlying database. The interface extends the JpaRepository interface and specifies the Job entity and the data type of its primary key Integer.
The interface contains several custom finder methods that use the naming convention of Spring Data JPA to automatically generate the queries.
In summary, this code implements a simple REST ful API for managing Job objects with endpoints for performing CRUD operations.
1. IAdminRepo
2. ICommentRepo
3. IFollowerRepo
4. IFollowingRepo
5. ILikeRepo
6. IPostRepo
7. ITokenRepo
8. IUserRepo
___
### **Model package**
Model package Consist of **Eight** Classes and One Enum
1. Admin
2. AuthenticationToken
3. InstagramComment
4. InstagramFollower
5. InstagramFollowing
6. Post
7. PostLike
8. User

All below annotations are applied on each class above:
1. **@Entity:** Indicates that this class is a JPA entity and should be mapped to a database table.
2. **@Table:** Specifies the name of the database table to which this entity is mapped.
3. **@Id:** Indicates that the id field is the primary key of the entity.
4. **@GeneratedValue:** Specifies the strategy for generating values for the primary key. In this case, it uses GenerationType.AUTO.
___
### **dto**
This is Data-To-Object package used for SignIn and SignOut
1. SignInInput
2. SignInOutput
3. SignUpOutput