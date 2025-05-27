package com.example.book_service_processing.lending.application;

import com.example.book_service_processing.common.UseCase;
import com.example.book_service_processing.lending.domain.Loan;
import com.example.book_service_processing.lending.domain.LoanId;
import com.example.book_service_processing.lending.domain.LoanRepository;

@UseCase
public class ReturnBookUseCase {

    private final LoanRepository loanRepository;

    public ReturnBookUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void execute(LoanId loanId) {
        Loan loan = loanRepository.findByIdOrThrow(loanId);
        loan.returned();
        loanRepository.save(loan);
    }
}
