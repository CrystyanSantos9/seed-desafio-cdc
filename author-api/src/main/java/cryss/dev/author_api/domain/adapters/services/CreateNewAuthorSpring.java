package cryss.dev.author_api.domain.adapters.services;

import cryss.dev.author_api.domain.adapters.services.mapper.AuthorMapper;
import cryss.dev.author_api.domain.ports.services.CreateNewAuthor;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.AuthorResponse;
import org.openapitools.model.NewAuthor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateNewAuthorSpring implements CreateNewAuthor {

    private final  AuthorMapper mapper;

    @Override
    public AuthorResponse create(NewAuthor author) {
        return new AuthorResponse ();
//        return mapper.toAuthor(author);
    }
}
