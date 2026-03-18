package com.bidzana.library.domain.service;

import com.bidzana.library.domain.model.Book;
import com.bidzana.library.domain.ports.BookRepositoryPort;

public class BookReservationService {

    private final BookRepositoryPort repository;

    // Injection par constructeur (meilleure pratique)
    public BookReservationService(BookRepositoryPort repository) {
        this.repository = repository;
    }

    public void reserveBook(String isbn) {
        Book book = repository.findByIsbn(isbn)
                .orElseThrow(() -> new RuntimeException("Livre introuvable avec l'ISBN : " + isbn));

        Book reservedBook = book.reserve(); // Appelle la logique du record Book
        repository.save(reservedBook);
    }
}