package cryss.dev.category_api.infraestructure.adapters.repositories.jpa.author;


import cryss.dev.category_api.domain.author.Author;
import cryss.dev.category_api.domain.author.AuthorRepository;
import cryss.dev.category_api.infraestructure.exception.BusinessException;
import cryss.dev.category_api.infraestructure.mappers.AuthorMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

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

    @Override
    public Author findById(Long id) {
        return mapper.toAuthor (repository.findById (id).orElseThrow (()->
             BusinessException.builder ()
                     .httpStatusCode (org.springframework.http.HttpStatus.BAD_REQUEST)
                        .code (String.valueOf (HttpStatus.SC_BAD_REQUEST))
                        .message ("Not found.")
                        .description (String.format ("AuthorId=%s not found.", id))
                        .build ()
        ));
    }

}
