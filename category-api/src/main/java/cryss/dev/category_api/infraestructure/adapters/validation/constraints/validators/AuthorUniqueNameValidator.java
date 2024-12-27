package cryss.dev.category_api.infraestructure.adapters.validation.constraints.validators;

import cryss.dev.category_api.domain.category.UniqueFieldValidator;
import cryss.dev.category_api.infraestructure.adapters.repositories.jpa.author.SpringAuthorRepositoryJPA;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.NewAuthor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@RequiredArgsConstructor
public class AuthorUniqueNameValidator implements UniqueFieldValidator, Serializable {

    private final SpringAuthorRepositoryJPA repository;

    @Override
    public Boolean isValid(Object object) {
        NewAuthor category = (NewAuthor) object;
       return  !repository.findAuthorByName (category.getName ()).isPresent ();
    }

    @Override
    public Boolean accept(Object object) {
        return object instanceof NewAuthor;
    }

}
