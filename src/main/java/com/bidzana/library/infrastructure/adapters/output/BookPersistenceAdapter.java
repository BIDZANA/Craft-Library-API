package com.bidzana.library.infrastructure.adapters.output;

import com.bidzana.library.domain.model.Book;
import com.bidzana.library.domain.ports.BookRepositoryPort;
import com.bidzana.library.infrastructure.adapters.output.repositories.BookJpaRepository;
import com.bidzana.library.infrastructure.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BookPersistenceAdapter implements BookRepositoryPort {

    private final BookJpaRepository jpaRepository;
    private final BookMapper mapper;

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return jpaRepository.findByIsbn(isbn)
                .map(mapper::toDomain);
    }

    @Override
    public void save(Book book) {
        jpaRepository.save(mapper.toEntity(book));
    }
}