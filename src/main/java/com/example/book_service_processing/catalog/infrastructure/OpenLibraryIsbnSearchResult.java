package com.example.book_service_processing.catalog.infrastructure;

import java.util.List;

record OpenLibraryIsbnSearchResult(

        List<String> publishers,

        String title,

        List<String> isbn_13,

        int revision
) {
}
