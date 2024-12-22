package cryss.dev.author_api.domain.adapters.services.mapper;

import cryss.dev.author_api.domain.Author;
import org.mapstruct.Mapper;
import org.openapitools.model.NewAuthor;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AuthorMapper {

    Author toAuthor(NewAuthor author);
}
