# **About Assignment**
## **Name :-** UrlHitCounter
## **Framework :-** Spring
## **Language :-** Java
---
## **Data Flow**
Here is a breakdown of the code:

1. **import org.springframework.web.bind.annotation.* :** This imports the necessary classes from the Spring Framework for defining a REST API.
1. **import java.util.HashMap :** This imports the HashMap class from the Java standard library for storing user visitor counts.
1. **@RestController:** This is a Spring annotation that indicates that this class defines a REST API controller.
1. **@RequestMapping("api/v1/visitor-count-app") :** This maps the controller to the URL path /api/v1/visitor-count-app. All methods in this class will be mapped to URLs relative to this base path.
1. **public class UrlHitController :** This is the name of the class that defines the REST API.
1. **private static int count = 0 :** This is a private static variable that stores the total number of visitors to the web application.
1. **private HashMap<String, Integer> userMap = new HashMap<>() :** This is a private instance variable that stores the number of visitors for each user. It is implemented as a HashMap with keys representing user names and values representing the number of times the user has visited the application.
1. **@GetMapping("/count/{userName}") :** This is a Spring annotation that maps a GET request with the URL /count/{userName} to the getVisitorByUser method.
1. **public String getVisitorByUser(@PathVariable String userName) :** This is a method that handles GET requests to /count/{userName}. It takes a String parameter userName, which is obtained from the URL path using the @PathVariable annotation. If userName is not null, the method updates the user visitor count in userMap and increments the total visitor count using the plusCount() method. It then returns a String containing the user name and the number of times they have visited the application.
1. **@GetMapping("/count") :** This is a Spring annotation that maps a GET request with the URL /count to the getHits method.
1. **public String getHits() :** This is a method that handles GET requests to /count. It increments the total visitor count using the plusCount() method and returns a String containing the total visitor count.
1. **public void plusCount() :** This is a method that increments the total visitor count. It is called by both getVisitorByUser and getHits.