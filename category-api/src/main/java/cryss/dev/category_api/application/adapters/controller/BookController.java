package cryss.dev.category_api.application.adapters.controller;

import cryss.dev.category_api.domain.book.ListAllAvaiableBooksUseCase;
import cryss.dev.category_api.domain.book.CreateBookUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.openapitools.api.BooksApi;
import org.openapitools.model.BookResponse;
import org.openapitools.model.ListAvaiableBooksResponse;
import org.openapitools.model.NewBook;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Log4j2
@Validated
public class BookController implements BooksApi {

    private final CreateBookUseCase createBookUseCase;
    private final ListAllAvaiableBooksUseCase listAllAvaiableBooksUseCase;


    @Override
    public ResponseEntity<BookResponse> createNewBook(NewBook newBook) {
        return ResponseEntity.ok (createBookUseCase.create(newBook));
    }

    @Override
    public ResponseEntity<ListAvaiableBooksResponse> listAllBooks() {
        return  ResponseEntity.ok (listAllAvaiableBooksUseCase.listAllBooks ());
    }
}

