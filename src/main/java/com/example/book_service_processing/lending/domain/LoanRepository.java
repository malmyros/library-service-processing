package com.example.book_service_processing.lending.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LoanRepository extends CrudRepository<Loan, LoanId> {

    @Query("select count(*) from Loan where copyId = :id and returnedAt is null")
    boolean isAvailable(CopyId copyId);

    default Loan findByIdOrThrow(LoanId loanId) {
        return findById(loanId).orElseThrow();
    }
}
