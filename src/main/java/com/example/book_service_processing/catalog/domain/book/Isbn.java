package com.example.book_service_processing.catalog.domain.book;

import org.apache.commons.validator.routines.ISBNValidator;

public record Isbn(String value) {

    private static final ISBNValidator ISBN_VALIDATOR = new ISBNValidator();

    public Isbn {
        if (!ISBN_VALIDATOR.isValid(value)) {
            throw new IllegalArgumentException("invalid isbn: " + value);
        }
    }
}
