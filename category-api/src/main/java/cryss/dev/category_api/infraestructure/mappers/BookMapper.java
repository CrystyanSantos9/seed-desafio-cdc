package cryss.dev.category_api.infraestructure.mappers;

import cryss.dev.category_api.domain.book.Book;
import cryss.dev.category_api.infraestructure.adapters.repositories.jpa.book.BookEntityJPA;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.openapitools.model.BookResponse;
import org.openapitools.model.NewBook;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {


    Book toNewBookDomain(NewBook newBook);

    BookEntityJPA toNewBookEntity(Book domain);

    BookResponse toNewBookDTO(BookEntityJPA response);
}
