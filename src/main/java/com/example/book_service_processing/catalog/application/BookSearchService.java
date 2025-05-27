package com.example.book_service_processing.catalog.application;

import com.example.book_service_processing.catalog.domain.book.Isbn;

public interface BookSearchService {

    BookInformation search(Isbn isbn);
}
