# **About Assignment**
## **Name :-** E-Commerse
## **Framework :-** Spring
## **Language :-** Java
---
## **Data Flow**
### **Application Properties**
This is a configuration file for a Spring Boot application using the H2 in-memory database.

1. **spring.datasource.url** specifies the database URL.
1. **spring.datasource.driverClassName** specifies the JDBC driver class.
1. **spring.datasource.username and spring.datasource.password** specify the credentials to use for database authentication.
1. **spring.jpa.database-platform** specifies the Hibernate dialect to use for this database.
1. **spring.h2.console.enabled** enables the H2 console, which is a web-based database management interface.

The following properties are specific to Hibernate and control how SQL queries are displayed in the console:

1. **spring.jpa.properties.hibernate.show_sql** specifies whether to display the SQL statements executed by Hibernate in the console.
1. **spring.jpa.properties.hibernate.use_sql_comments** specifies whether to include comments in the SQL output.
1. **spring.jpa.properties.hibernate.format_sql** specifies whether to format the SQL output for readability.
___
### **Controller Package**
This package consist of **StudentController** and **EventController**. 
#### **UserController Class**
The above code represents a UserController class in a Spring Boot application. This class is responsible for handling HTTP requests related to user entities.

The class is annotated with @RestController and @RequestMapping annotations. The @RestController annotation indicates that this class is a controller component in the Spring application context that handles RESTful web service requests. The @RequestMapping annotation is used to map HTTP requests to handler methods of this class. The value attribute of this annotation specifies the base URI of the request mapping.

The UserController class has two handler methods:

**getById:** This method is a GET request mapping that maps to the URI /user/{id}. It retrieves a user entity by its ID and returns it as an optional User object. The @PathVariable annotation is used to extract the id value from the request URI. The getById method calls the userService.getById(id) method to retrieve the user entity.

**addUser:** This method is a POST request mapping that maps to the URI /user/insert. It creates a new user entity in the database by calling the userService.addUser(user) method. The @RequestBody annotation is used to extract the user entity from the request body.

Both handler methods use the userService field, which is autowired using the @Autowired annotation, to delegate the actual business logic to the UserService class.

#### **AddressController Class**
The AddressController is a Spring REST controller that handles HTTP requests related to Address objects. It has one endpoint for adding an Address object via a POST request.

The @RestController and @RequestMapping annotations are used to define this class as a REST controller and to specify the base URL path for all endpoints in this controller.

The @Autowired annotation is used to inject an instance of the AddressService class, which will be used to handle business logic related to Address objects.

The addAddress() method is mapped to the URL "/address/insert" using the @PostMapping annotation. It takes an Address object in the request body and passes it to the addAddress() method of the injected AddressService instance.

The addAddress() method returns a String message indicating whether the Address object was successfully saved or not.

#### **ProductController Class**
This is a code for a Spring Boot REST API controller for the Product model.

The ProductController class is annotated with @RestController and @RequestMapping(value = "/product"), indicating that it will handle HTTP requests related to the /product endpoint.

It has three methods:

**getAll:** A @GetMapping method that takes in a category parameter from the path and returns an iterable list of Product objects. This method is used to retrieve all products that belong to a particular category.

**addProduct:** A @PostMapping method that takes in a Product object as the request body and saves it to the database. This method is used to add a new product to the system.

**deleteById:** A @DeleteMapping method that takes in an id parameter from the path and deletes the corresponding Product object from the database. This method is used to delete a product from the system.

#### **ProductController Class**
This is a Java Spring REST controller for handling HTTP requests related to orders. The controller has two endpoints:

**GET /order/{id} -** This endpoint takes an order ID as a path parameter and returns an optional OrderDetails object corresponding to the provided ID. The ID is parsed from a string to an integer and passed to the OrderService component to retrieve the order from the database.

**POST /order/insert -** This endpoint takes a JSON request body containing an OrderDetails object and creates a new order in the database by passing the order details to the OrderService component. The method returns a message indicating whether the order was successfully saved or not.

The controller uses the OrderService component, which is responsible for the business logic of handling orders. The service is autowired into the controller using Spring's dependency injection mechanism.
___
### **Service Package**
This package consist of two classes **StudentService** and **EventService**

#### **AddressService class**
This code appears to be a Java class called AddressService that is annotated with @Service. Here is what this annotation means:

**@Service:** This annotation is from the Spring framework, and it marks this class as a service that will handle business logic for the Address entity.

The class has one field:

**addressRepo:** An IAddressRepo object that is annotated with @Autowired. This indicates that Spring should inject an instance of the IAddressRepo interface into this field automatically, using dependency injection.

The class has one method:

**addAddress():** This method takes an Address object as an argument and returns a String message. The method calls the save() method on the addressRepo object to save the Address object to the database, and then checks whether the save operation was successful. If it was, the method returns the message "Address Saved". If it was not, the method returns the message "Address is not saved".

#### **UserService class**
This code appears to be a Java class called UserService that is annotated with @Service. Here is what this annotation means:

**@Service:** This annotation is from the Spring framework, and it marks this class as a service that will handle business logic for the User entity.

The class has one field:

**userRepo:** An IUserRepo object that is annotated with @Autowired. This indicates that Spring should inject an instance of the IUserRepo interface into this field automatically, using dependency injection.

The class has two methods:

**getById():** This method takes a String id as an argument and returns an Optional object that contains a User object with the corresponding id, if it exists in the database. The method calls the findById() method on the userRepo object to find the User object with the specified id.

**addUser():** This method takes a User object as an argument and returns a String message. The method calls the save() method on the userRepo object to save the User object to the database, and then checks whether the save operation was successful. If it was, the method returns a message that includes the id of the saved User object. If it was not, the method returns the message "User is not saved".

#### **ProductService class**
The above code represents a ProductService class in a Spring Boot application. This class is responsible for managing the product-related functionality of the application.

The class is annotated with @Service, indicating that it is a service component in the Spring application context. It also has an @Autowired field of type IProductRepo, which is a Spring Data JPA repository interface for the Product entity.

The getAll method retrieves all products from the database and returns them as an iterable collection. The method takes in a parameter Category, but it is not used within the method.

The addProduct method saves a new Product object to the database using the productRepo.save() method. If the object is saved successfully, the method returns a string with the message "Product saved with id : <id>". If not, the method returns a string with the message "Product is not saved".

The deleteById method deletes a Product object from the database using the productRepo.deleteById() method. The method takes in a parameter id, which is the ID of the product to be deleted. If the deletion is successful, the method returns a string with the message "Product with id : <id> has been deleted". If not, the method returns a string with the message "Product Deletion Failed"

#### **OrderService class**
The above code represents an OrderService class in a Spring Boot application. This class is responsible for managing the order-related functionality of the application.

The class is annotated with @Service, indicating that it is a service component in the Spring application context. It also has an @Autowired field of type IOrderRepo, which is a Spring Data JPA repository interface for the OrderDetails entity.

The getById method retrieves an order from the database by its ID and returns it as an optional OrderDetails object. The method takes in a parameter id, which is the ID of the order to be retrieved.

The createOrder method saves a new OrderDetails object to the database using the orderRepo.save() method. If the object is saved successfully, the method returns a string with the message "Order saved with id : <id>". If not, the method returns a string with the message "Order is not saved". The method takes in a parameter orderDetails, which is the OrderDetails object to be saved.
___
### **Repository Package**
This package consist four interface **IAddressRepo, IOrderRepo, IProductRepo, IUserRepo**

These are Java interface definition for a Spring Data JPA repository for managing Student entities. Here's an explanation of the annotations and methods used in this code:

1. **@Repository:** This annotation is used to indicate that this interface is a Spring Data repository.
1. The interface extends the JpaRepository interface, which is part of the Spring Data JPA framework. This interface provides a set of generic methods for performing common database operations on a User entity, such as saving, updating, and deleting records. The JpaRepository interface takes two type parameters: the first is the entity type (User in this case), and the second is the type of the entity's primary key (Integer in this case).

In other words, this interface defines a repository that can be used to perform database operations on User entities, and it inherits a set of methods from the JpaRepository interface that provide generic implementations of common database operations.
___
### **Model package**
Model package Consist of four **class** : **User**, **Product**, **Address** and **OrderDetails** 

All these classes implements lombok

1. **@Data:** This annotation is from the Lombok library, and it generates getters, setters, toString, equals, and hashCode methods for all of the fields in the class.
1. **@AllArgsConstructor:** This annotation is also from Lombok, and it generates a constructor that accepts all of the fields in the class as arguments.
1. **@NoArgsConstructor:** This annotation is again from Lombok, and it generates a constructor that takes no arguments.
1. **@Entity:** This annotation is from the JPA (Java Persistence API) and it marks this class as a persistent entity, meaning that it can be saved to a database

#### **User class**
This code appears to be a Java class called Address that is annotated with @Data, @AllArgsConstructor, @NoArgsConstructor, and @Entity. Here is what each of these annotations means:

The class has five fields:
1. **id:** An Integer field annotated with @Id and @GeneratedValue. This field represents the unique identifier for the Address object, and it will be automatically generated by the database when a new Address object is saved.
1. **name:** A String field that represents the name of the person associated with this address.
1. **landmark:** A String field that represents a nearby landmark that can help identify this address.
1. **phoneNo:** A String field that represents the phone number associated with this address.
1. **zipCode:** A String field that represents the ZIP code associated with this address.

Finally, there is a @OneToOne annotation on the user field, which indicates that this field represents a one-to-one relationship with another entity (presumably a User entity). The cascade = CascadeType.ALL parameter means that any operations performed on an Address object should also be performed on the associated User object (for example, if an Address object is deleted, the associated User object should also be deleted).

#### **Product Class**
This code appears to be a Java class called Product that is annotated with @Data, @AllArgsConstructor, @NoArgsConstructor, and @Entity. Here is what each of these annotations means:

The class has six fields:
1. **id:** An Integer field annotated with @Id and @GeneratedValue. This field represents the unique identifier for the Product object, and it will be automatically generated by the database when a new Product object is saved.
1. **name:** A String field that represents the name of the product.
1. **price:** An Integer field that represents the price of the product.
1. **description:** A String field that represents the description of the product.
1. **category:** A String field that represents the category of the product (e.g. electronics, clothing, etc.).
1. **brand:** A String field that represents the brand of the product.

Together, these fields represent the basic information that might be associated with a product in an e-commerce system.

#### **Address Class**
This code appears to be a Java class called Address that is annotated with @Data, @AllArgsConstructor, @NoArgsConstructor, and @Entity. Here is what each of these annotations means:

The class has five fields:

1. **id:** An Integer field annotated with @Id and @GeneratedValue. This field represents the unique identifier for the Address object, and it will be automatically generated by the database when a new Address object is saved.
1. **name:** A String field that represents the name of the person associated with this address.
1. **landmark:** A String field that represents a nearby landmark that can help identify this address.
1. **phoneNo:** A String field that represents the phone number associated with this address.
1. **zipCode:** A String field that represents the ZIP code associated with this address.

Finally, there is a @OneToOne annotation on the user field, which indicates that this field represents a one-to-one relationship with another entity (presumably a User entity). The cascade = CascadeType.ALL parameter means that any operations performed on an Address object should also be performed on the associated User object (for example, if an Address object is deleted, the associated User object should also be deleted).

#### **OrderDetails Class**
This code appears to be a Java class called OrderDetails that is annotated with @Data, @AllArgsConstructor, @NoArgsConstructor, and @Entity. Here is what each of these annotations means:

The class has five fields:

1. **id:** An Integer field annotated with @Id and @GeneratedValue. This field represents the unique identifier for the OrderDetails object, and it will be automatically generated by the database when a new OrderDetails object is saved.
1. **user:** A @ManyToOne relationship with a User entity. This indicates that each OrderDetails object is associated with one User object, but that multiple OrderDetails objects can be associated with the same User object.
1. **product:** A @ManyToOne relationship with a Product entity. This indicates that each OrderDetails object is associated with one Product object, but that multiple OrderDetails objects can be associated with the same Product object.
1. **address:** A @ManyToOne relationship with an Address entity. This indicates that each OrderDetails object is associated with one Address object, but that multiple OrderDetails objects can be associated with the same Address object.
1. **productQuantity:** An Integer field that represents the quantity of the associated Product object that was ordered.

Together, these fields represent the details of an order that a user has placed in an e-commerce system, including the user who placed the order, the product that was ordered, the address to which the product should be delivered, and the quantity of the product that was ordered.