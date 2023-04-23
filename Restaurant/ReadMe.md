# **About Assignment**
## **Name :-** RestaurantManagement
## **Framework :-** Spring
## **Language :-** Java
---
## **Data Flow**
### **Controller Package**
The controller is annotated with @RestController which indicates that it is a REST controller and @RequestMapping which specifies the base URL path for all endpoints in this controller.

The ServiceRestaurant instance is autowired using @Autowired annotation, which injects an instance of the ServiceRestaurant class into the controller.

There are four endpoints defined in this controller:

1. **getId -** GET request to retrieve the ID of a restaurant by name. The name is passed as a path variable and the ID is returned as a string.

1. **getRestaurants -** GET request to retrieve a list of all restaurants.

1. **addRestaurant -** POST request to add a new restaurant. The request body contains a JSON representation of a Restaurant object.

1. **updateSpeciality -** PUT request to update the speciality of a restaurant by name. The name and new speciality are passed as path variables.

1. **deleteRestaurant -** DELETE request to delete a restaurant by name. The name is passed as a path variable.

For each endpoint, the HTTP method and the endpoint URL are specified using the @RequestMapping annotation. The @PathVariable annotation is used to map the path variables to the method arguments.

The response from each endpoint is returned as a string, indicating the status of the operation.
___
### **Service Package**
#### **This package consist of :**
1. **model package**
2. **ServiceRestaurant class**
#### **model package**
This package consist of **Address** class and **Restaurant** class.
1. **Address class**
    * This is a Java class representing an Address object. It is annotated with @Component, which is a Spring Framework annotation indicating that this class should be treated as a Spring bean.
    * The class has three instance variables streetName, city, and state, representing the address properties. The class has two constructors, one with no arguments and another with three arguments, to create an Address object with a specified street name, city, and state.
    * The class has getter and setter methods for each instance variable, which provide access to the values of the address properties.
    * This class can be used in a Spring application as a Spring bean by creating an instance of the Address class and injecting it into other classes using Spring's dependency injection mechanism. The @Component annotation marks this class as a candidate for automatic detection and configuration by Spring's component-scanning mechanism.
.
2. **Restaurant Class**
    * This is a Java class representing a Restaurant object. It is annotated with @Component, which is a Spring Framework annotation indicating that this class should be treated as a Spring bean.
    * The class has instance variables id, name, address, mobileNo, speciality, and totalStaff, representing properties of a restaurant.
    * The class has two constructors, one with no arguments and another with arguments for each property of the Restaurant object.
    * The @Autowired annotation is used to automatically inject a Address object into the Restaurant object. This is achieved through Spring's dependency injection mechanism, where Spring will automatically look for a bean of type Address and inject it into the address variable.
    * The class has getter and setter methods for each instance variable, which provide access to the values of the restaurant properties.
    * This class can be used in a Spring application as a Spring bean by creating an instance of the Restaurant class and injecting it into other classes using Spring's dependency injection mechanism. The @Component annotation marks this class as a candidate for automatic detection and configuration by Spring's component-scanning mechanism.
#### **ServiceRestaurant class**
This is a Java class representing a Service layer component of a Restaurant Management System. It provides various services related to Restaurant entities by accessing the Repository layer through the Autowired RepoRestaurant object.

The class is annotated with the @Service annotation, which indicates that it is a Service layer component and its object will be managed by the Spring container.

The class has the following public methods:

1. **getId(String name):** This method takes a restaurant name as input, and returns the restaurant id associated with the given name by searching the restaurantList from RepoRestaurant.

1. **getRestaurantRepo():** This method returns a list of all the restaurants in the restaurantList from RepoRestaurant.

1. **addRestaurant(Restaurant restaurant):** This method takes a Restaurant object as input, and adds it to the restaurantList in RepoRestaurant.

1. **updateSpeciality(String name, String speciality):** This method takes a restaurant name and a new speciality as input, updates the speciality of the restaurant with the given name and returns a boolean indicating whether the update was successful or not.

1. **deleteRestaurant(String name):** This method takes a restaurant name as input, deletes the restaurant with the given name from the restaurantList in RepoRestaurant and returns a boolean indicating whether the deletion was successful or not.
___
### **Repository Package**
1. This is a Java class representing a repository for Restaurant objects. It is annotated with @Repository, which is a Spring Framework annotation indicating that this class should be treated as a Spring bean.
1. The class has an instance variable restaurantList, which is a list of Restaurant objects.
1. The class has a constructor that creates a default Restaurant object and adds it to the restaurantList.
1. The class has three methods: getRestaurantList(), addRestaurant(), and deleteRestaurant(). The getRestaurantList() method returns the restaurantList instance variable. The addRestaurant() method takes a Restaurant object as input and adds it to the restaurantList. The deleteRestaurant() method takes a Restaurant object as input and removes it from the restaurantList.
1. This class can be used in a Spring application as a Spring bean by creating an instance of the RepoRestaurant class and injecting it into other classes using Spring's dependency injection mechanism. The @Repository annotation marks this class as a candidate for automatic detection and configuration by Spring's component-scanning mechanism.

### Assignment Summary
The Restaurant Management is a web-based application designed to manage user information. The system allows users to create, update, and delete user profiles, including personal details and contact information. The system is built using Java Spring framework. The objective of this is to get better understanding of **CRUD** operations using the HTTP Requests and have hands on practical experience.