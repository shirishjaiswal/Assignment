# **About Assignment**
## **Name :-** JobSearchPortal
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
### **Controller Package**
This package consist of **JobController**. The controller contains several methods for handling HTTP requests related to jobs.
The **@RestController** annotation indicates that this class is a REST controller that will handle HTTP requests.
The **@RequestMapping** annotation is used to specify the base URL for all endpoints in this controller, which in this case is ***/job***.
The **@Autowired** annotation is used to inject a dependency on a "JobService" instance into the controller.
The controller contains the following methods:

1. **getAllJobs()** : This method handles a GET request to ***/job/all*** and returns an Iterable of all jobs.

1. **getJobById(String id)** : This method handles a GET request to ***/job/byId/{id}*** and returns an Optional of a job with the specified ID.

1. **getJobByName(String companyName)** : This method handles a GET request to ***/job/byCompanyName/{companyName}*** and returns an Optional of a job with the specified company name.

1. **orderBySalary()**: This method handles a GET request to ***/job/orderBy/asc*** and returns an Iterable of all jobs ordered by salary.

1. **getJobByCategory(String category)** : This method handles a GET request to ***/job/byCategory/{category}*** and returns a List of jobs with the specified category.

1. **addJobList(Iterable<Job> jobs)** : This method handles a POST request to ***/job/inserts*** and adds a list of jobs.

1. **addJob(Job job)** : This method handles a POST request to ***/job/insert*** and adds a single job.

1. **deleteJobById(String id)** : This method handles a DELETE request to ***/job/byId/{id}*** and deletes the job with the specified ID.

1. **deleteJobByName(String companyName)** : This method handles a DELETE request to ***/job/byName/{companyName}*** and deletes the job with the specified company name.

1. **updateJobTitleForId(String id, String title)** : This method handles a PUT request to ***/job/update/{id}/title/{title}*** and updates the title of the job with the specified ID.

1. **updateJobSalaryForId(String id, String salary)** : This method handles a PUT request to ***/job/update/{id}/salary/{salary}*** and updates the salary of the job with the specified ID.
___
### **Service Package**
This is a Java Spring Boot service class that contains methods for performing CRUD (Create, Read, Update, Delete) operations on job objects. It is annotated with **@Service**, which is a Spring stereotype annotation indicating that this class is a service.

The JobService class uses an instance of JobRepo, which is an interface that extends the Spring Data JPA Repository interface. This means that it inherits the basic CRUD operations (save, find, delete, etc.) and allows the developer to define custom methods.

The methods defined in the JobService class are:

1. **getAllJobs()** : returns all jobs in the repository using the findAll() method inherited from the JobRepo interface.

1. **getJobById(String id)** : returns a job by its ID using the findById() method inherited from the JobRepo interface.

1. **getJobsByCompanyName(String companyName)** : returns a job by its company name using a custom method defined in the JobRepo interface.

1. **getJobsByCategory(String name)** : returns a list of jobs by their job category using a custom method defined in the JobRepo interface.

1. **orderBySalary()** : returns all jobs in the repository sorted by salary using a custom method defined in the JobRepo interface.

1. **addJobs(Iterable<Job> jobs)** : saves a list of jobs using the saveAll() method inherited from the JobRepo interface.

1. **addJob(Job job)** : saves a single job using the save() method inherited from the JobRepo interface.

1. **deleteJobById(String id)** : deletes a job by its ID using the deleteById() method inherited from the JobRepo interface.

1. **deleteJobByCompanyName(String companyName)** : deletes all jobs by a company name using a custom method defined in the JobRepo interface.

1. **updateTitleById(String title, String id)** : updates a job's title by its ID using a custom method defined in the JobRepo interface.

1. **updateSalaryById(String salary, String id)** : updates a job's salary by its ID using a custom method defined in the JobRepo interface.
___
### **Repository Package**
This package consist an interface called **JobRepo** which defines a set of methods that can be used to interact with the underlying database. The interface extends the JpaRepository interface and specifies the Job entity and the data type of its primary key Integer.

The interface contains several custom finder methods that use the naming convention of Spring Data JPA to automatically generate the queries. For example, findByCompanyName will find all jobs with a given company name, findByJobType will find all jobs with a given job category type and deleteByCompanyName will delete all jobs with a given company name.

The interface also contains several custom query methods that use SQL queries to update the job's title or salary based on their id. These methods are annotated with **@Query** to specify the SQL queries, **@Modifying** to indicate that these methods will modify the database, and **@Transactional** to indicate that these methods should be executed within a transaction.

The **@Param** annotation is used to specify the parameter names in the SQL queries. The updateJobSetTitleForId method takes a String parameter title and an Integer parameter id and updates the title of the job with the given id. The updateJobSetSalaryForId method takes a Double parameter salary and an Integer parameter id and updates the salary of the job with the given id.

In summary, this code implements a simple RESTful API for managing Job objects with endpoints for performing CRUD operations. The JobController class defines the endpoints and uses JobService to handle business logic, while JobService uses JobRepo to interact with the database.
___
### **Model package**
Model package Consist of a **class** : **Job** and an **Enum** : **JobCategory** 

#### **JobCategory Enum**
This is a Java enumeration that defines various job categories that are used in the application. The categories defined in this enumeration are:

1. **CONSTRUCTION**
1. **MARKETING**
1. **MANAGEMENT**
1. **ENGINEERING**
1. **ACCOUNTING**
1. **SALES**
1. **DOCTOR**

Each of these categories represents a type of job, and they are used in the application to categorize the jobs. The enumeration uses a comma-separated list of values, with each value representing a different category.
#### **Job class**
This is a Java class named Job that represents a job posting. The class is annotated with several JPA (Java Persistence API) annotations to map it to a database table. The annotations include:

1. **@Entity:** Indicates that this class is a JPA entity and should be mapped to a database table.
1. **@Table:** Specifies the name of the database table to which this entity is mapped.
1. **@Id:** Indicates that the id field is the primary key of the entity.
1. **@GeneratedValue:** Specifies the strategy for generating values for the primary key. In this case, it uses GenerationType.AUTO.
1. **@Column:** Maps the field to a database column. The attributes updatable, nullable, and length are used to specify the properties of the column.
1. **@Enumerated:** Specifies that the jobType field is an enumerated type and should be persisted as a string in the database.

The class has the following fields:
1. **id:** The primary key of the job posting.
1. **title:** The title of the job posting, with a length between 5 and 50 characters.
1. **description:** The description of the job posting, with a maximum length of 400 characters.
1. **location:** The location of the job posting.
1. **salary: The salary of the job posting.
1. **companyName:** The name of the company that posted the job.
1. **employerName:** The name of the employer who posted the job.
1. **jobType:** The category of the job, which is an enumerated type.
___
### **Assignment Summary**
The Job search portal is a web-based application designed to manage Jobs. The system allows users to create, update, and delete Job profiles. The system is built using Java Spring framework. The objective of this is to get better understanding of **CRUD** operations using the HTTP Requests and the main Focus of this assignment is on connecting the **H2DB** and have hands on practical experience.