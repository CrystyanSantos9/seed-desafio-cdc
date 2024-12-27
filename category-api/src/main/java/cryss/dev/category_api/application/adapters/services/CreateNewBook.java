package cryss.dev.category_api.application.adapters.services;

import cryss.dev.category_api.domain.author.AuthorRepository;
import cryss.dev.category_api.domain.book.BookRepository;
import cryss.dev.category_api.domain.book.BookValidator;
import cryss.dev.category_api.domain.book.ServiceBook;
import cryss.dev.category_api.domain.category.CategoryRepository;
import cryss.dev.category_api.infraestructure.mappers.AuthorMapper;
import cryss.dev.category_api.infraestructure.mappers.BookMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.BookResponse;
import org.openapitools.model.NewBook;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor

public class CreateNewBook implements ServiceBook {

    private final BookMapper mapper;
    private final BookRepository repository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final AuthorMapper authorMapper;
    private final List<BookValidator> validators;

    @Override
    @Transactional
    public BookResponse create(NewBook newBook) {
        var domain = mapper.toNewBookDomain(newBook);
        validators.forEach (validators-> validators.isValid (domain));
        var entity = mapper.toNewBookEntity(domain);

        // no microsserviço, esses caras seriam os clientes web
        var category = categoryRepository.findById(entity.getCategory ().getId ());
        //Aquele ele retorna um elemento de domínio ( talvez eu tenha que alterar )
        var authorDomain = authorRepository.findById(entity.getAuthor ().getId ());

        entity.setCategory (category);
        entity.setAuthor (authorMapper.toAuthorJPAEntity (authorDomain));

        var response = repository.create (entity);

        return mapper.toNewBookDTO(response);
    }
}
