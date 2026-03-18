package com.bidzana.library.domain.model;
import com.bidzana.library.domain.exception.OutOfStockException;

public record Book(Long id, String isbn, String title, String author, int stock) {
    public Book reserve() {
        if (stock <= 0) {
            throw new OutOfStockException("Le livre avec l'ISBN " + isbn + " est épuisé.");
        }
        return new Book(id, isbn, title, author, stock - 1);
    }
}
