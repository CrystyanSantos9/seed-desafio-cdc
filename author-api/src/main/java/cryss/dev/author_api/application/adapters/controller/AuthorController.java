package cryss.dev.author_api.application.adapters.controller;

import cryss.dev.author_api.domain.ports.services.CreateNewAuthor;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.AuthorApi;
import org.openapitools.model.AuthorResponse;
import org.openapitools.model.NewAuthor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuthorController implements AuthorApi {

    private final CreateNewAuthor createNewAuthor;

    @Override
    public ResponseEntity<AuthorResponse> create(NewAuthor newAuthor) {
        return ResponseEntity.ok (createNewAuthor.create (newAuthor ));
    }
}
