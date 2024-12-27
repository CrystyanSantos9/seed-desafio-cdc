package cryss.dev.category_api.domain.author;


import java.util.Optional;

public interface AuthorRepository {
    Author create(Author author);

    Author findById(Long id);
}
