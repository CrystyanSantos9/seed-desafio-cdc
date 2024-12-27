package cryss.dev.category_api.infraestructure.adapters.repositories.jpa.book;

import cryss.dev.category_api.domain.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringBookRepositoryJPA extends JpaRepository<BookEntityJPA, Long> {
    Optional<Boolean> findBookByTitle(Book book);

    Boolean existsByTitle(String title);

    Boolean existsByIsbn(String isbn);
}
