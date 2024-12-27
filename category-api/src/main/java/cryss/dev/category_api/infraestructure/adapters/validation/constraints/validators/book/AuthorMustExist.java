package cryss.dev.category_api.infraestructure.adapters.validation.constraints.validators.book;

import cryss.dev.category_api.domain.author.AuthorRepository;
import cryss.dev.category_api.domain.book.Book;
import cryss.dev.category_api.domain.book.BookValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorMustExist implements BookValidator {

    private final AuthorRepository repository;

    @Override
    public void isValid(Book book) {
        repository.findById (book.getAuthor ().getId ());
    }
}
