package com.example.book_service_processing.catalog.application;

import com.example.book_service_processing.catalog.domain.book.Isbn;

public interface IsbnSearchService {

    BookInformation search(Isbn isbn);
}
