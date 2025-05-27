package com.example.book_service_processing.catalog.application;

import com.example.book_service_processing.common.UseCase;
import com.example.book_service_processing.catalog.domain.book.BookId;
import com.example.book_service_processing.catalog.domain.copy.BarCode;
import com.example.book_service_processing.catalog.domain.copy.Copy;
import com.example.book_service_processing.catalog.domain.copy.CopyRepository;

@UseCase
public class RegisterBookCopyUseCase {

    private final CopyRepository copyRepository;

    public RegisterBookCopyUseCase(CopyRepository copyRepository) {
        this.copyRepository = copyRepository;
    }

    public void execute(BookId bookId, BarCode barCode) {
        copyRepository.save(new Copy(bookId, barCode));
    }
}
