package cryss.dev.category_api.application.adapters.controller;

import cryss.dev.category_api.domain.author.CreateNewAuthor;
import cryss.dev.category_api.domain.category.ServiceCategory;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.openapitools.api.AuthorApi;
import org.openapitools.api.CategoryApi;
import org.openapitools.model.AuthorResponse;
import org.openapitools.model.CategoryResponse;
import org.openapitools.model.NewAuthor;
import org.openapitools.model.NewCategory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Log4j2
@Validated
public class AuthorController implements AuthorApi {

    private final CreateNewAuthor createNewAuthor;

    @Override
    public ResponseEntity<AuthorResponse> createNewAuthor(NewAuthor newAuthor) {
        log.info ("message={}, method={}, request={}","Creating a new Author", "create", newAuthor );
        return ResponseEntity.ok (createNewAuthor.create (newAuthor ));
    }
}

