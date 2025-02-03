package ru.matchdecor.previewer;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PreviewerApplication {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    public static void main(String[] args) {
        SpringApplication.run(PreviewerApplication.class, args);
    }

    @Bean
    public CommandLineRunner checkDatabaseConfig() {
        return args -> System.out.println("DATABASE URL: " + dbUrl);
    }
}