package com.example.book_service_processing.catalog.application;

import com.example.book_service_processing.common.UseCase;
import com.example.book_service_processing.catalog.domain.book.Book;
import com.example.book_service_processing.catalog.domain.book.BookRepository;
import com.example.book_service_processing.catalog.domain.book.Isbn;

@UseCase
public class AddBookToCatalogUseCase {

    private final BookRepository bookRepository;
    private final BookSearchService bookSearchService;

    public AddBookToCatalogUseCase(
            BookRepository bookRepository,
            BookSearchService bookSearchService) {

        this.bookRepository = bookRepository;
        this.bookSearchService = bookSearchService;
    }

    public void execute(Isbn isbn) {
        BookInformation bookInformation = bookSearchService.search(isbn);
        bookRepository.save(new Book(bookInformation.title(), isbn));
    }
}
