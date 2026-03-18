package com.bidzana.library.infrastructure.config;

import com.bidzana.library.domain.ports.BookRepositoryPort;
import com.bidzana.library.domain.service.BookReservationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {

    @Bean
    public BookReservationService bookReservationService(BookRepositoryPort bookRepositoryPort) {
        return new BookReservationService(bookRepositoryPort);
    }
}
