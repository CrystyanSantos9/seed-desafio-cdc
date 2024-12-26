package cryss.dev.category_api.infraestructure.adapters.repositories.jpa;


import cryss.dev.category_api.domain.author.Author;
import cryss.dev.category_api.domain.author.AuthorRepository;
import cryss.dev.category_api.infraestructure.mappers.AuthorMapper;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Log4j2
public class AuthorRepositoryJPA implements AuthorRepository {

    private final SpringAuthorRepositoryJPA repository;
    private final AuthorMapper mapper;


    @Override
    public Author create(Author author) {
        var entity = mapper.toAuthorJPAEntity(author);
        var result = repository.save (entity);
        var domain = mapper.toAuthor (result);
        log.info ("message={}, method={}, request={}","Creating a new Author", "create",  result .getId ());
        return domain ;
    }

}
