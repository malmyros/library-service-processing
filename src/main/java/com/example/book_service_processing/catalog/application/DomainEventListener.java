package com.example.book_service_processing.catalog.application;

import com.example.book_service_processing.catalog.domain.copy.Copy;
import com.example.book_service_processing.catalog.domain.copy.CopyId;
import com.example.book_service_processing.catalog.domain.copy.CopyRepository;
import com.example.book_service_processing.lending.domain.LoanClosed;
import com.example.book_service_processing.lending.domain.LoanCreated;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Component
public class DomainEventListener {

    private final CopyRepository copyRepository;

    public DomainEventListener(CopyRepository copyRepository) {
        this.copyRepository = copyRepository;
    }

    @ApplicationModuleListener
    public void handle(LoanCreated loanCreated) {
        CopyId copyId = new CopyId(loanCreated.copyId().id());
        Copy copy = copyRepository.findById(copyId).orElseThrow();
        copy.makeUnavailable();
        copyRepository.save(copy);
    }

    @ApplicationModuleListener
    public void handle(LoanClosed loanClosed) {
        CopyId copyId = new CopyId(loanClosed.copyId().id());
        Copy copy = copyRepository.findById(copyId).orElseThrow();
        copy.makeAvailable();
        copyRepository.save(copy);
    }
}
