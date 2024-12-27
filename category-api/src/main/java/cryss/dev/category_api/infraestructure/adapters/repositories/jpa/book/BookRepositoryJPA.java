package cryss.dev.category_api.infraestructure.adapters.repositories.jpa.book;

import cryss.dev.category_api.domain.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BookRepositoryJPA implements BookRepository {

    private final SpringBookRepositoryJPA repository;

    @Override
    public BookEntityJPA create(BookEntityJPA bookEntityJPA) {
        return repository.save (bookEntityJPA);
    }

    @Override
    public Boolean existsByTitle(String title) {
        return repository.existsByTitle (title);
    }

    @Override
    public Boolean existsByIsbn(String isbn) {
        return repository.existsByIsbn (isbn);
    }
}
