package com.example.book_service_processing.catalog.domain.copy;

import com.example.book_service_processing.catalog.domain.book.BookId;
import jakarta.persistence.*;
import org.springframework.util.Assert;

@Entity
public class Copy {

    @EmbeddedId
    private CopyId id;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "book_id"))
    private BookId bookId;

    @Embedded
    private BarCode barCode;

    private boolean available;

    Copy() {
    }

    public Copy(BookId bookId, BarCode barCode) {
        Assert.notNull(bookId, "book Id must not be null");
        Assert.notNull(barCode, "barcode must not be null");
        this.id = new CopyId();
        this.bookId = bookId;
        this.barCode = barCode;
        this.available = true;
    }

    public void makeUnavailable() {
        this.available = false;
    }

    public void makeAvailable() {
        this.available = true;
    }
}
