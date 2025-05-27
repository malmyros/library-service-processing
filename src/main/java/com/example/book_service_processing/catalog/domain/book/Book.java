package com.example.book_service_processing.catalog.domain.book;

import jakarta.persistence.*;
import org.springframework.util.Assert;

@Entity
public class Book {

    @EmbeddedId
    private BookId bookId;

    private String title;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "isbn"))
    private Isbn isbn;

    private boolean available;

    Book() {
    }

    public Book(String title, Isbn isbn) {
        Assert.notNull(title, "title cannot be null");
        Assert.notNull(isbn, "isbn cannot be empty");
        this.bookId = new BookId();
        this.title = title;
        this.isbn = isbn;
    }

    void makeAvailable() {
        available = true;
    }
}
