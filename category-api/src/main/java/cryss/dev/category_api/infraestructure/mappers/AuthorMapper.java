package cryss.dev.category_api.infraestructure.mappers;

import cryss.dev.category_api.domain.author.Author;
import cryss.dev.category_api.infraestructure.adapters.repositories.jpa.AuthorJPAEntity;
import org.mapstruct.Mapper;
import org.openapitools.model.AuthorResponse;
import org.openapitools.model.NewAuthor;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AuthorMapper {

    Author toAuthor(NewAuthor author);

    Author toAuthor(AuthorJPAEntity author);

    AuthorResponse toAuthorResponse(Author entity);

    AuthorJPAEntity toAuthorJPAEntity(Author author);
}
