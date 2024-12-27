package cryss.dev.category_api.infraestructure.adapters.validation.constraints.validators.book;

import cryss.dev.category_api.domain.book.Book;
import cryss.dev.category_api.domain.book.BookRepository;
import cryss.dev.category_api.domain.book.BookValidator;
import cryss.dev.category_api.infraestructure.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IsbnIsUnique implements BookValidator {

    private final BookRepository repository;

    @Override
    public void isValid(Book book) {
        if(repository.existsByIsbn (book.getIsbn ())){
            throw new BusinessException (HttpStatus.BAD_REQUEST,null,"Field value must be unique", "book isbn value already in use.", "MS-API");
        }
    }
}
