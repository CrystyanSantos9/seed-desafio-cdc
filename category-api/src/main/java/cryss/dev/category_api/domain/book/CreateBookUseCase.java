package cryss.dev.category_api.domain.book;

import org.openapitools.model.BookResponse;
import org.openapitools.model.NewBook;

public interface CreateBookUseCase {
    BookResponse create(NewBook newBook);
}
