package com.DIocOne.DIoc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CConfig {
    @Bean
    public Dog getDog () {
        System.out.println("Spring Passing object to Autowired");
        return new Dog("Fluffy");
    }
}
