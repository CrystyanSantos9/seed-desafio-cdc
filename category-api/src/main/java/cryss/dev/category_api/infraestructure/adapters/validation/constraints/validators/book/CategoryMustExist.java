package cryss.dev.category_api.infraestructure.adapters.validation.constraints.validators.book;

import cryss.dev.category_api.domain.book.Book;
import cryss.dev.category_api.domain.book.BookValidator;
import cryss.dev.category_api.domain.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryMustExist implements BookValidator {

    private final CategoryRepository repository;

    @Override
    public void isValid(Book book) {
        repository.findById (book.getCategory ().getId ());
    }
}
