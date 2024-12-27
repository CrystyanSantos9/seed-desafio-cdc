package cryss.dev.category_api.domain.book;

import org.openapitools.model.BookResponse;
import org.openapitools.model.NewBook;

public interface ServiceBook {
    BookResponse create(NewBook newBook);
}
