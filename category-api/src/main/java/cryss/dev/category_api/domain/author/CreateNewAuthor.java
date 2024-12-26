package cryss.dev.category_api.domain.author;

import org.openapitools.model.AuthorResponse;
import org.openapitools.model.NewAuthor;

public interface CreateNewAuthor {
    AuthorResponse create(NewAuthor author);
}
