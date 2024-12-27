package cryss.dev.category_api.domain.author;



public interface AuthorRepository {
    Author create(Author author);

    Author findById(Long id);
}
