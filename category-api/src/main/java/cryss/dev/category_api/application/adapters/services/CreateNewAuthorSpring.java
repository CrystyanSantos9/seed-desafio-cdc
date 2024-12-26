package cryss.dev.category_api.application.adapters.services;


import cryss.dev.category_api.domain.author.CreateNewAuthor;
import cryss.dev.category_api.infraestructure.adapters.repositories.jpa.AuthorRepositoryJPA;
import cryss.dev.category_api.infraestructure.mappers.AuthorMapper;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.AuthorResponse;
import org.openapitools.model.NewAuthor;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

//import javax.validation.Valid;

@Component
@RequiredArgsConstructor
@Validated
public class CreateNewAuthorSpring implements CreateNewAuthor {

    private final AuthorMapper mapper;
    private final AuthorRepositoryJPA repository;

    @Override
    public AuthorResponse create(NewAuthor author) {
        var domain = mapper.toAuthor (author);
        var entity = repository.create (domain);
        return mapper.toAuthorResponse (entity);
    }
}
