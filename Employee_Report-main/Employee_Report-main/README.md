# Employee Report Management System

The Employee Management System using Spring Boot is a web-based application designed to streamline the management of employee data for an organization. This application provides an easy-to-use interface for HR personnel to manage employee information such as personal details, job roles, salary information, and more. The application also allows employees to view their own information and make updates to their personal details.

## Features

- **Employee Record Management:** The system allows the HR department to manage employee records such as personal information, job roles, salary details, and more.
- **Employee Self-Service:** The system allows employees to view their own personal information and make updates to their profiles.
- **Reporting:** The system provides various reports such as employee attendance, employee performance, and more.

## Technology Stack

The project utilizes the following technologies:

- **Spring Boot:** Provides a robust framework for developing enterprise-level Java applications.
- **Spring MVC:** Enables the development of web applications using the Model-View-Controller design pattern.
- **Hibernate/JPA:** Provides an Object-Relational Mapping (ORM) solution for managing database interactions.
- **MySQL:** A popular open-source relational database management system.

## Project Modules

The project is divided into the following modules:

1. **Employee Management Module:** This module allows HR personnel to create employee records such as personal information, job roles, salary details, and more.
2. **Employee Self-Service Module:** This module allows employees to view and update their own personal information.
3. **Reporting Module:** This module provides various reports such as employee attendance, and employee performance etc.

## Getting Started

To get started with the Employee Management System, follow these steps:

1. Clone the project repository from [GitHub](https://github.com/satyam1459/Employee_Report).
2. Set up a MySQL database and update the database configuration in the application properties file.
3. Build the project using Maven or your preferred build tool.
4. Run the application on a local server.
5. Access the application through the provided URL and start managing employee data.

## Employee API
1.Get all employee

```
https://localhost:8080/employee
```
2.Get a employee by id
```
https://localhost:8080/employee
```
3.Update employee

   Other parameter can be also update by employee except jobRole and salary details.

   
<img width="356" alt="image" src="https://github.com/satyam1459/Employee_Report/assets/114183531/58a3d40b-e722-486a-9bbc-c5b7554ffa69">


## Admin API
1.Add an employee

<img width="356" alt="image" src="https://github.com/satyam1459/Employee_Report/assets/114183531/b022dde3-7d7d-4e4c-954f-3eb4ef2d3de2">


## Report API
1.Add performance for a day and attendance by emp_id

<img width="356" alt="image" src="https://github.com/satyam1459/Employee_Report/assets/114183531/a005c925-a443-4020-84cb-4f6a38a3b3d6">

## Conclusion

The Employee Management System using Spring Boot is a user-friendly and efficient application that streamlines the management of employee data. This application provides an easy-to-use interface for HR personnel to manage employee information and allows employees to view and update their own personal details. With its advanced features such as reporting and user management, this application is a valuable tool for any organization looking to manage their employee data effectively.
