package com.example.book_service_processing.lending.domain;

import jakarta.persistence.*;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.util.Assert;

import java.time.LocalDate;

@Entity
public class Loan extends AbstractAggregateRoot<Loan> {

    @EmbeddedId
    private LoanId loanId;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "copy_id"))
    private CopyId copyId;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "user_id"))
    private UserId userId;

    private LocalDate createdAt;

    private LocalDate expectedReturnDate;

    private LocalDate returnedAt;

    @Version
    private short version;

    Loan() {
    }

    public Loan(
            CopyId copyId,
            UserId userId,
            LoanRepository loanRepository) {

        Assert.notNull(copyId, "copy id must not be null");
        Assert.notNull(userId, "user id must not be null");
        Assert.isTrue(loanRepository.isAvailable(copyId), "book is no available for loan");

        this.loanId = new LoanId();
        this.copyId = copyId;
        this.userId = userId;
        this.createdAt = LocalDate.now();
        this.expectedReturnDate = LocalDate.now().plusDays(30);
        this.registerEvent(new LoanCreated(this.copyId));
    }

    public void returned() {
        this.returnedAt = LocalDate.now();
        if (this.returnedAt.isAfter(expectedReturnDate.atStartOfDay().toLocalDate())) {
            // TODO: calculate fee
        }
        this.registerEvent(new LoanClosed(this.copyId));
    }
}
