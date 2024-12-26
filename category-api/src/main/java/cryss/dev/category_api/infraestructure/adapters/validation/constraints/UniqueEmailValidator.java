package cryss.dev.category_api.infraestructure.adapters.validation.constraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final cryss.dev.category_api.infraestructure.adapters.repositories.jpa.SpringAuthorRepositoryJPA repository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
         return !repository.findAuthorByEmail (value).isPresent ();
    }
}
