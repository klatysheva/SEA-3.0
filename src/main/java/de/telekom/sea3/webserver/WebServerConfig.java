package de.telekom.sea3.webserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration

public class WebServerConfig {
    @Bean
    public Cat cat() {
        return new Cat("Susi");
    //return Class.forName("de.telekom.sea3.webserver.Cat").newInstance();
    }
}

