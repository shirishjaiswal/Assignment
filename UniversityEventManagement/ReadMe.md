# **About Assignment**
## **Name :-** UniversityEventManagement
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
#### **StudentController Class**
This is a Java class definition for a RESTful API controller for managing Student resources. Here is a brief explanation of the annotations and methods used in this code:

1. **@RestController:** This annotation is used to indicate that the class is a RESTful API controller.
1. **@RequestMapping:** This annotation is used to specify the base URL for all the endpoints in the controller.
1. **StudentService studentService:** This is an instance of the StudentService class that is used to perform CRUD operations on Student resources.
1. **@GetMapping:** This annotation is used to specify that the annotated method should handle GET requests.
1. **@PathVariable:** This annotation is used to bind a URI template variable to a method parameter.
1. **@PostMapping:** This annotation is used to specify that the annotated method should handle POST requests.
1. **@RequestBody:** This annotation is used to indicate that the request body should be deserialized into the annotated parameter.
1. **@DeleteMapping:** This annotation is used to specify that the annotated method should handle DELETE requests.
1. **@PutMapping:** This annotation is used to specify that the annotated method should handle PUT requests.
1. **Iterable<Student> getAllStudents():** This method returns an iterable collection of all Student resources.
1. **Optional<Student> getStudentById(String id): **This method returns an optional Student resource with the specified ID.
1. **String addStudent(Student student):** This method adds a new Student resource to the database and returns a success message.
1. **String deleteStudentById(String id):** This method deletes the Student resource with the specified ID from the database and returns a success message.
1. **String updateStudentDtp(String dtp, String id):** This method updates the department field of the Student resource with the specified ID to the specified value and returns a success message.

#### **EventController Class**
This is a Java class definition for a RESTful API controller for managing Event resources. Here is a brief explanation of the annotations and methods used in this code:

1. **@RestController:** This annotation is used to indicate that the class is a RESTful API controller.
1. **@RequestMapping:** This annotation is used to specify the base URL for all the endpoints in the controller.
1. **EventService eventService:** This is an instance of the EventService class that is used to perform CRUD operations on Event resources.
1. **@GetMapping:** This annotation is used to specify that the annotated method should handle GET requests.
1. **@PathVariable:** This annotation is used to bind a URI template variable to a method parameter.
1. **@PostMapping:** This annotation is used to specify that the annotated method should handle POST requests.
1. **@RequestBody:** This annotation is used to indicate that the request body should be deserialized into the annotated parameter.
1. **@DeleteMapping:** This annotation is used to specify that the annotated method should handle DELETE requests.
1. **@PutMapping:** This annotation is used to specify that the annotated method should handle PUT requests.
1. **Iterable<Event> getAllEventByDate(String date):** This method returns an iterable collection of all Event resources that occur on the specified date.
1. **String deleteEventById(String id):** This method deletes the Event resource with the specified ID from the database and returns a success message.
1. **String addEvent(Event event):** This method adds a new Event resource to the database and returns a success message.
1. **String updateEventLocationForId(String location, String id):** This method updates the location field of the Event resource with the specified ID to the specified value and returns a success message
___
### **Service Package**
This package consist of two classes **StudentService** and **EventService**

#### **StudentService class**
This code defines a Java Spring StudentService class that provides CRUD (Create, Read, Update, and Delete) operations for a Student entity.

The StudentService class contains the following methods:

1. **getAllStudents():** This method retrieves all the Student entities from the database using the findAll() method provided by the IStudentRepo interface. It returns an Iterable of Student objects.

1. **getStudentById(String id):** This method retrieves a Student entity by its id from the database using the findById() method provided by the IStudentRepo interface. It returns an Optional of Student object, which could be empty if the Student entity with the specified id does not exist.

1. **addStudent(Student student):** This method adds a Student entity to the database using the save() method provided by the IStudentRepo interface. It returns a message indicating that the Student entity is saved.

1. **deleteStudentById(String id):** This method deletes a Student entity by its id from the database using the deleteById() method provided by the IStudentRepo interface. It returns a message indicating whether the Student entity with the specified id is deleted or not.

1. **updateStudentDtp(String dtp, String id):** This method updates the Department field of a Student entity by its id in the database using a custom method updateStudentSetDepartmentForId() provided by the IStudentRepo interface. It first converts the dtp parameter to uppercase and then tries to parse it to a Department enum. If the parsing is successful, it updates the Department field of the Student entity with the specified id to the parsed Department enum value and returns a message indicating that the Student entity is updated with the new Department. If the parsing fails, it returns a message indicating that the update is failed.

#### **EventService class**
This code defines a Java Spring EventService class that provides CRUD (Create, Read, Update, and Delete) operations for an Event entity.

The EventService class contains the following methods:

1. **addEvent(Event event):** This method adds an Event entity to the database using the save() method provided by the IEventRepo interface. If the Event entity is saved successfully, it returns a message indicating success, otherwise, it returns a message indicating failure.

1. **deleteEvent(String id):** This method deletes an Event entity by its id from the database using the deleteById() method provided by the IEventRepo interface. If the Event entity with the specified id is deleted successfully, it returns a message indicating success, otherwise, it returns a message indicating failure.

1. **getAllEventByDate(String date):** This method retrieves all the Event entities from the database that have the specified date using a custom method getAllEventByDate() provided by the IEventRepo interface. It converts the date parameter to a LocalDate object using the LocalDate.parse() method and then passes it to the getAllEventByDate() method. It returns an Iterable of Event objects.

1. **updateLocationById(String location, String id):** This method updates the location field of an Event entity by its id in the database using a custom method updateEventSetLocationForId() provided by the IEventRepo interface. It updates the location field of the Event entity with the specified id to the new location parameter value and returns a message indicating success if the update is successful, otherwise, it returns a message indicating failure.
___
### **Repository Package**
This package consist two interface **IStudentRepo** and **IEventRepo**

#### **IStudentRepo**
This is a Java interface definition for a Spring Data JPA repository for managing Student entities. Here's an explanation of the annotations and methods used in this code:

1. **@Repository:** This annotation is used to indicate that this interface is a Spring Data repository.
1. **public interface IStudentRepo extends JpaRepository<Student, Integer>:** This line defines the repository interface as a subclass of the JpaRepository interface, which provides generic CRUD methods for entities of type Student with Integer IDs.
1. **@Modifying:** This annotation is used to indicate that the query being executed is a modifying query.
1. **@Transactional:** This annotation is used to indicate that the method should be executed within a transaction.
1. **@Query:** This annotation is used to define a custom query. In this case, the value attribute specifies the SQL query to execute, and the nativeQuery attribute is set to true to indicate that this is a native SQL query.
1. **int updateStudentSetDepartmentForId(@Param("dtp")String dtp, @Param("id") Integer id):** This method updates the department field of the Student entity with the specified ID to the specified value and returns the number of affected rows. The @Param annotation is used to map the method parameters to named parameters in the SQL query.

#### **IEventRepo**
This is a Java interface definition for a Spring Data JPA repository for managing Event entities. Here's an explanation of the annotations and methods used in this code:

1. **@Repository:** This annotation is used to indicate that this interface is a Spring Data repository.
1. **public interface IEventRepo extends1. JpaRepository<Event, Integer>:** This line defines the repository interface as a subclass of the JpaRepository interface, which provides generic CRUD methods for entities of type Event with Integer IDs.
1. **@Modifying:** This annotation is used to indicate that the query being executed is a modifying query.
1. **@Query:** This annotation is used to define a custom query. In this case, the value attribute specifies the SQL query to execute, and the nativeQuery attribute is set to true to indicate that this is a native SQL query.
1. **Iterable<Event> getAllEventByDate(LocalDate date):** This method retrieves all Event entities whose date field matches the specified date parameter value.
1. **int updateEventSetLocationForId(@Param("location") String location, @Param("id") Integer id):** This method updates the location field of the Event entity with the specified ID to the specified value and returns the number of affected rows. The @Param annotation is used to map the method parameters to named parameters in the SQL query.
___
### **Model package**
Model package Consist of two **class** : **Student** and **Event** and an **Enum** : **Department** 

#### **Department Enum**
This code defines an enumeration type called Department. An enumeration is a fixed set of named values, and in this case, each value corresponds to a department name.

The Department enumeration contains 14 possible values: 
1. MECHANICAL
1. ELECTRICAL
1. MATERIALS
1. ENVIRONMENTAL 
1. BIOMEDICAL
1. PETROLEUM
1. SOFTWARE
These values are separated by commas and are listed on a single line for readability.
#### **Student class**
This is a Java class definition for a Student entity that likely maps to a database table using Java Persistence API (JPA). Here is a brief explanation of the annotations used in this code:

1. **@Data:** This is a Lombok annotation that generates boilerplate code such as getters, setters, and constructors automatically.
1. **@AllArgsConstructor:** This Lombok annotation generates a constructor with all the arguments in the class.
1. **@NoArgsConstructor:** This Lombok annotation generates a no-argument constructor for the class.
1. **@Table:** This JPA annotation specifies the name of the database table to which the class is mapped.
1. **@Entity:** This JPA annotation indicates that the class is an entity that can be persisted in a database.
1. **@Id:** This JPA annotation specifies that the annotated field is the primary key of the database table.
1. **@GeneratedValue:** This JPA annotation specifies the strategy used to generate the value of the annotated field. In this case, the strategy is GenerationType.AUTO, which lets the database choose the generation strategy.
1. **@Column:** This JPA annotation specifies the properties of the database column to which the annotated field is mapped, such as whether the column is updatable or nullable.
1. **@Length:** This is a Hibernate annotation that specifies the minimum and maximum length of the annotated string field.
1. **@Min:** This is a Hibernate annotation that specifies the minimum value of the annotated numeric field.
1. **@Max:** This is a Hibernate annotation that specifies the maximum value of the annotated numeric field.
1. **@Enumerated:** This JPA annotation specifies the type of the annotated enum field, either EnumType.ORDINAL (the default) or EnumType.STRING. In this case, the type is EnumType.STRING.
1. **private:** This is an access modifier that specifies that the field is private and cannot be accessed from outside the class.

#### **Event class**
This is a Java class definition for an Event entity that likely maps to a database table using Java Persistence API (JPA). Here is a brief explanation of the annotations used in this code:

1. **@Data:** This is a Lombok annotation that generates boilerplate code such as getters, setters, and constructors automatically.
1. **@AllArgsConstructor:** This Lombok annotation generates a constructor with all the arguments in the class.
1. **@NoArgsConstructor:** This Lombok annotation generates a no-argument constructor for the class.
1. **@Table:** This JPA annotation specifies the name of the database table to which the class is mapped.
1. **@Entity:** This JPA annotation indicates that the class is an entity that can be persisted in a database.
1. **@Id:** This JPA annotation specifies that the annotated field is the primary key of the database table.
1. **@GeneratedValue:** This JPA annotation specifies the strategy used to generate the value of the annotated field. In this case, the strategy is GenerationType.AUTO, which lets the database choose the generation strategy.
1. **@Column:** This JPA annotation specifies the properties of the database column to which the annotated field is mapped, such as whether the column is updatable or nullable.
1. **private:** This is an access modifier that specifies that the field is private and cannot be accessed from outside the class.
1. **Integer id:** This is a field of type Integer that represents the unique identifier of an event in the database.
1. **String name:** This is a field of type String that represents the name of an event.
1. **String location:** This is a field of type String that represents the location of an event.
1. **LocalDate date:** This is a field of type LocalDate that represents the date of an event.
1. **LocalTime fromTime:** This is a field of type LocalTime that represents the start time of an event.
1. **LocalTime toTime:** This is a field of type LocalTime that represents the end time of an event
___
### **Assignment Summary**
The University Event Management web-based application designed to manage Event and the Students. The system allows users to create, update, and delete Event and Student profiles. The system is built using Java Spring framework. The objective of this is to get better understanding of **CRUD** operations using the HTTP Requests and the main Focus of this assignment is on connecting the **H2DB** and have hands on practical experience.