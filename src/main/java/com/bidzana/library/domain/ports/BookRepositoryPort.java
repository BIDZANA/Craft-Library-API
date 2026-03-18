package com.bidzana.library.domain.ports;

import com.bidzana.library.domain.model.Book;
import java.util.Optional;

public interface BookRepositoryPort {
    Optional<Book> findByIsbn(String isbn);
    void save(Book book);
}
