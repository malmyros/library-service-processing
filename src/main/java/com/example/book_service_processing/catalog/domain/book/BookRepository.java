package com.example.book_service_processing.catalog.domain.book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, BookId> {

}
