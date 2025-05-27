package com.example.book_service_processing.lending.application;


import com.example.book_service_processing.common.UseCase;
import com.example.book_service_processing.lending.domain.CopyId;
import com.example.book_service_processing.lending.domain.Loan;
import com.example.book_service_processing.lending.domain.LoanRepository;
import com.example.book_service_processing.lending.domain.UserId;

@UseCase
public class RentBookUseCase {

    private final LoanRepository loanRepository;

    public RentBookUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void execute(CopyId copyId, UserId userId) {
        loanRepository.save(new Loan(copyId, userId, loanRepository));
    }
}
