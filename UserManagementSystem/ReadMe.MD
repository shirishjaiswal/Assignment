# **About Assignment**
## **Name :-** UserSystemManagement
## **Framework :-** Spring
## **Language :-** Java
---
## **Data Flow**
### **Controller Package**
This package consist of **userController** class has a single instance variable : **userService**, which is autowired using the @Autowired annotation. The userService variable is an instance of a UserService class, which provides the methods to perform CRUD (Create, Read, Update, Delete) operations on user objects.

The class has five methods that are mapped to HTTP requests:

1. **users():** This method handles GET requests to the "/users" endpoint and returns a list of all users.

2. **userById():** This method handles GET requests to the "/userId/{userId}" endpoint and returns a specific user by ID.

3. **userAdd():** This method handles POST requests to the "/user" endpoint and adds a new user.

4. **userDelete():** This method handles DELETE requests to the "/userId/{userId}" endpoint and deletes a specific user by ID.

5. **userUpdate():** This method handles PUT requests to the "/userId" endpoint and updates an existing user.

Each method is annotated with an HTTP method annotation, such as *@GetMapping*, *@PostMapping*, *@DeleteMapping*, and *@PutMapping*, to specify the HTTP method that the method handles. The methods are also annotated with the *@RequestBody* and *@PathVariable* annotations to handle request body and path variable parameters, respectively.

The ***userAdd()*** and ***userUpdate()*** methods require a request body parameter of type User, which is deserialized from the JSON request body using the @RequestBody annotation. 
The ***userById()*** and ***userDelete()*** methods require a path variable parameter of type String, which is extracted from the URL using the @PathVariable annotation.
___
### **Service Package**
#### **This package consist of :**
1. **model package**
2. **UserService class**
#### **model package**
This package consist of **Address** class and **User** class.
1. **Address class**
    * This is a Java class that represents an Address object with three properties: **city**, **state**, and **country**. The class has two constructors: a default constructor with no arguments, and a constructor that takes three arguments - city, state, and country. The class also has getter and setter methods for each of the properties.
    * The class is annotated with the @Component annotation. This annotation indicates that the class is a Spring bean, which can be used by other Spring components.
2. **User**
    * This is a Java class that represents a User object with five properties: **userId**, **name**, **userName**, **address**, and **mobileNo**. The class has two constructors: a default constructor with no arguments, and a constructor that takes five arguments - userId, name, userName, address, and mobileNo. The class also has getter and setter methods for each of the properties.
    * The class has an instance variable of the Address class, which is annotated with the @Autowired annotation.
    * The class is annotated with the @Component annotation. This annotation indicates that the class is a Spring bean, which can be used by other Spring components.
#### **UserService class**
This class is used to represent Buisness Logic. 
1. **@Service:** This annotation is used to mark this class as a service bean and it will be automatically detected by Spring during component scanning.

1. **@Autowired:** This annotation is used to auto-wire the UserDatabase bean into the UserService class.

1. **List<User> getUsers():** This method retrieves all the users from the database by calling the getUsers() method of the UserDatabase bean and returns a list of User objects.

1. **User userFindById(String userId):** This method takes in a userId as a parameter and returns the corresponding User object from the database by calling the getUsers() method of the UserDatabase bean and iterating over the list to find the user with matching userId.

1. **boolean addUserInDB(User user):** This method adds a new User object to the database by calling the addUser() method of the UserDatabase bean and returns true if the user is successfully added, false otherwise.

1. **boolean userDelete(String userId):** This method deletes a User object from the database by calling the userDelete() method of the UserDatabase bean and returns true if the user is successfully deleted, false otherwise.

1. **User getUserById(String userId):** This method retrieves a User object from the database by calling the userFindById() method and returns the corresponding User object.

1. **boolean userUpdate(User user):** This method updates the information of an existing User object in the database by first retrieving the User object from the database, updating its fields if necessary, deleting the old object from the database, and adding the updated object to the database. It returns true if the update is successful, false otherwise.
___
### **Repository Package**
It consist of UserDatabase class. It maintains a list of User objects in memory and provides methods to perform CRUD (Create, Read, Update, Delete) operations on the list.

The class is annotated with **@Repository**, which is a Spring stereotype annotation that indicates that this class is a repository component. This annotation is used to mark the classes that work as a data access layer in the Spring framework.

The UserDatabase class has a constructor that initializes the userDB list with some dummy data. It provides three methods:

1. **getUsers():** returns the list of all users in the database.
1. **addUser():** adds a new user to the database.
1. **userDelete():** deletes a user from the database.

Note that this implementation does not persist the data to any external database, it just maintains the list of users in memory.

### Assignment Summary
The User Management System is a web-based application designed to manage user information. The system allows users to create, update, and delete user profiles, including personal details and contact information. The system is built using Java Spring framework. The objective of this is to get better understanding of **CRUD** operations using the HTTP Requests and have hands on practical experience.
