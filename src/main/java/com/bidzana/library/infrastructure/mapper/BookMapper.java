package com.bidzana.library.infrastructure.mapper;

import com.bidzana.library.domain.model.Book;
import com.bidzana.library.infrastructure.adapters.output.entities.BookEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book toDomain(BookEntity entity);
    BookEntity toEntity(Book domain);
}