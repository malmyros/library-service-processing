package com.example.book_service_processing.catalog.infrastructure;

import com.example.book_service_processing.catalog.application.BookInformation;
import com.example.book_service_processing.catalog.application.IsbnSearchService;
import com.example.book_service_processing.catalog.domain.book.Isbn;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
class OpenLibraryBookSearchService implements IsbnSearchService {

    private final RestClient restClient;

    public OpenLibraryBookSearchService(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://openlibrary.org/")
                .build();
    }

    public BookInformation search(Isbn isbn) {

        OpenLibraryIsbnSearchResult openLibraryIsbnSearchResult = restClient.get()
                .uri("isbn/{isbn}.json", isbn.value())
                .retrieve()
                .body(OpenLibraryIsbnSearchResult.class);

        assert openLibraryIsbnSearchResult != null;
        return new BookInformation(openLibraryIsbnSearchResult.title());
    }

}
