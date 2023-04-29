# **About Assignment**
## **Name :-** UserManagementValidation
## **Framework :-** Spring
## **Language :-** Java
---
## **Data Flow**
### **Controller Package**
This package consist of UserController class which represent a controller for user management. The controller is responsible for handling HTTP requests related to user management and interacting with the business logic implemented in the UserService class. The class is annotated with **@Controller** and **@RequestMapping** annotations, which are used to define the controller as a Spring MVC controller and map the controller to the *"/userManagement"* URL path.

The UserController class has five methods, each of which handles a specific HTTP request:

1. **The allUsers()** method handles a GET request for the "/all" URL path and returns a list of all users.

1. **The userById()** method handles a GET request for the "/user/{id}" URL path, where {id} is a path variable representing the user ID, and returns the user with the specified ID.

1. **The addUser()** method handles a POST request for the "/add" URL path and adds a new user to the system.

1. **The delUser()** method handles a DELETE request for the "/delete/{id}" URL path, where {id} is a path variable representing the user ID, and deletes the user with the specified ID.

1. **The updateUser()** method handles a PUT request for the "/update/{id}" URL path, where {id} is a path variable representing the user ID, and updates the user with the specified ID.

All methods are annotated with **@RequestMapping** annotations that specify the HTTP request method and URL path that the method should handle. The **@ResponseBody**  annotation is used to indicate that the return value should be serialized and included in the response body.

The class has an **@Autowired**  annotation, which injects the UserService dependency into the controller. This means that the controller can use the methods provided by the UserService class to perform the business logic related to user management
___
### **Service Package**
This package consist of UserService class which  represents the service layer for user management. The UserService class is responsible for performing the business logic related to user management and interacting with the data layer implemented in the UserRepo class. The class is annotated with **@Service**, which is used to define the class as a Spring service.

The UserService class has six methods, each of which performs a specific operation related to user management:

1. **The byId()** method is a private helper method that returns the user object corresponding to the specified user ID.

1. **The getUser()** method returns the user object corresponding to the specified user ID.

1. **The addUser()** method adds a new user object to the system.

1. **The deleteUser()** method deletes the user object corresponding to the specified user ID from the system.

1. **The getUsers()** method returns a list of all users in the system.

1. **The updateUser()** method updates the user object corresponding to the specified user ID with the new user object passed as a parameter.

All methods use the **UserRepo** object to perform **CRUD** operations on user data. The class has an **@Autowired** annotation that injects the UserRepo dependency into the service. This means that the service can use the methods provided by the UserRepo class to interact with the database and perform data operations.

The **updateUser()** method updates the user object by first retrieving the existing user object using the **byId()** method and then updating its fields with the fields from the new user object passed as a parameter. The method then deletes the old user object using the **deleteUser()** method and adds the updated user object using the **addUser()** method.

The class also has a private **List<User> userList** field that is used to cache the list of users retrieved from the database. The userList field is used by the **byId()** method to perform a linear search for the user object corresponding to the specified user ID.
___
### **Repository Package**
This package contains **UserRepo class** represents the data layer for user management. The UserRepo class is responsible for performing CRUD operations on user data and interacting with the database. The class is annotated with **@Repository**, which is used to define the class as a Spring repository.

The UserRepo class has three methods, each of which performs a specific CRUD operation on user data:

1. **The getUsers()** method returns a list of all users in the system.

1. **The addUser()** method adds a new user object to the system.

1. **The deleteUser()** method deletes the specified user object from the system.

All methods use the userList field, which is a **private ArrayList<User>** that stores the user data. The userList field is used to perform CRUD operations on user data.

The **addUser()** method adds a new user object to the userList by using the **add()** method provided by the ArrayList class.

The **deleteUser()** method deletes the specified user object from the userList by using the **remove()** method provided by the ArrayList class.

Overall, the UserRepo class is a simple implementation of the data layer for user management. It does not include methods for updating user data, searching for specific users, or filtering users based on specific criteria. These functionalities can be added to the class if needed.
___
### **Model package**
This package contains User class which represents a user model. The User class contains instance variables that represent different properties of a user. The class uses Lombok annotations such as **@Data**, **@AllArgsConstructor**, and **@NoArgsConstructor** to automatically generate the getters, setters, constructors, and toString() method for the instance variables.

The User class has six instance variables:

1. The **id** variable represents the unique identifier of the user. It is annotated with **@NotNull** and **@Length(min = 3, max = 14)** to ensure that the id is not null and has a minimum length of 3 and a maximum length of 14 characters.

1. The **name** variable represents the name of the user. It is annotated with **@NotNull** and **@Length(min = 3, max = 14)** to ensure that the name is not null and has a minimum length of 3 and a maximum length of 14 characters.

1. The **email** variable represents the email address of the user. It is annotated with **@Email** to ensure that the email is a valid email address.

1. The **mobileNo** variable represents the mobile number of the user. It is annotated with **@Size(min = 10, max = 12)** to ensure that the mobile number has a minimum length of 10 and a maximum length of 12 digits.

1. The **dateOfBirth** variable represents the date of birth of the user. It is annotated with **@DateTimeFormat(pattern = "yyyy-MM-dd")** to ensure that the date is formatted in the "yyyy-MM-dd" pattern.

1. The **time** variable represents the time of creation of the user.

Overall, the User class is a simple model class that represents a user entity with some basic properties. The annotations used in the class ensure that the properties have valid values and are within certain limits.

### **Assignment Summary**
The User Management is a web-based application designed to manage user information. The system allows users to create, update, and delete user profiles. The system is built using Java Spring framework. The objective of this is to get better understanding of **CRUD** operations using the HTTP Requests and the main Focus of this assignment is on **Validation Dependencie** and have hands on practical experience.