package com.example.book_service_processing.catalog.domain.copy;

import org.springframework.util.Assert;

import java.util.UUID;

public record CopyId(UUID id) {

    public CopyId {
        Assert.notNull(id, "id must not be null");
    }

    public CopyId() {
        this(UUID.randomUUID());
    }
}
