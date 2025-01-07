package cryss.dev.category_api.infraestructure.mappers;

import cryss.dev.category_api.domain.book.Book;
import cryss.dev.category_api.infraestructure.adapters.repositories.jpa.book.BookEntityJPA;
import org.apache.commons.lang3.ObjectUtils;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.openapitools.model.AvaiableBooksResponse;
import org.openapitools.model.BookResponse;
import org.openapitools.model.ListAvaiableBooksResponse;
import org.openapitools.model.NewBook;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {


    Book toNewBookDomain(NewBook newBook);

    BookEntityJPA toNewBookEntity(Book domain);

    BookResponse toNewBookDTO(BookEntityJPA response);

    AvaiableBooksResponse toAvaiableBooksResponse(BookEntityJPA bookEntityJPA);

    List<AvaiableBooksResponse> mapToListAvaiableBooksResponse(List<BookEntityJPA> listbookEntityJPA);

    default ListAvaiableBooksResponse toListAvaiableBooksResponse(List<BookEntityJPA> listbookEntityJPA){
        ListAvaiableBooksResponse listAvaiableBooksResponse = ListAvaiableBooksResponse.builder ().build ();
        if (ObjectUtils.isNotEmpty (listbookEntityJPA)){
            return listAvaiableBooksResponse.content (mapToListAvaiableBooksResponse (listbookEntityJPA));
        }
        return listAvaiableBooksResponse;
    }

}
