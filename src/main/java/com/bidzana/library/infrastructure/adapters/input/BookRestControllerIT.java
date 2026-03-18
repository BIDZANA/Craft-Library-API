package com.bidzana.library.infrastructure.adapters.input;

import com.bidzana.library.infrastructure.adapters.output.entities.BookEntity;
import com.bidzana.library.infrastructure.adapters.output.repositories.BookJpaRepository;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BookRestControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookJpaRepository repository;

    @Test
    void should_reserve_book_successfully() throws Exception {
        // Given: Un livre existe en base avec 2 exemplaires
        String isbn = "12345";
        repository.save(new BookEntity(null, isbn, "Test Book", "Marvin Bidz", 2));

        // When: On appelle l'API de réservation
        String dtoJson = "{\"isbn\": \"" + isbn + "\"}";

        mockMvc.perform(post("/api/books/reserve")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dtoJson))
                .andExpect(status().isNoContent()); // Vérifie le code 204

        // Then: Le stock en base doit être descendu à 1
        BookEntity updatedBook = repository.findByIsbn(isbn).orElseThrow();
        assertThat(updatedBook.getStock()).isEqualTo(1);
    }
}