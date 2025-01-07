package cryss.dev.category_api.application.adapters.services;

import cryss.dev.category_api.domain.book.ListAllAvaiableBooksUseCase;
import cryss.dev.category_api.domain.book.BookRepository;
import cryss.dev.category_api.infraestructure.mappers.BookMapper;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.ListAvaiableBooksResponse;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ListAllAvaiableBooks implements ListAllAvaiableBooksUseCase {

    private final BookMapper mapper;
    private final BookRepository repository;

    @Override
    public ListAvaiableBooksResponse listAllBooks() {
        return mapper.toListAvaiableBooksResponse(repository.listAllAvaiableBooks());
    }
}
