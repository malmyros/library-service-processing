package com.example.book_service_processing.catalog.domain.book;

import org.springframework.util.Assert;

import java.util.UUID;

public record BookId(UUID id) {

    public BookId {
        Assert.notNull(id, "id must not be null");
    }

    public BookId() {
        this(UUID.randomUUID());
    }
}
