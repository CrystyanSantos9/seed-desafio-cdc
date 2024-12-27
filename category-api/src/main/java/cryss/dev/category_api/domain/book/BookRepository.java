package cryss.dev.category_api.domain.book;

import cryss.dev.category_api.infraestructure.adapters.repositories.jpa.book.BookEntityJPA;

import java.util.Optional;

public interface BookRepository {

    BookEntityJPA create(BookEntityJPA bookEntityJPA);

    Boolean existsByTitle(String title);

    Boolean existsByIsbn(String isbn);
}
