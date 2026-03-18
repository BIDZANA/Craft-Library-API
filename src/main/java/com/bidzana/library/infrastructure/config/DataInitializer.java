package com.bidzana.library.infrastructure.config;

import com.bidzana.library.infrastructure.adapters.output.entities.BookEntity;
import com.bidzana.library.infrastructure.adapters.output.repositories.BookJpaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(BookJpaRepository repository) {
        return args -> {
            repository.save(new BookEntity(null, "12345", "Clean Code", "Robert Martin", 2));
            System.out.println("Base de données initialisée avec le livre 'Clean Code'");
        };
    }
}