package cryss.dev.category_api.infraestructure.adapters.validation.constraints;

import cryss.dev.category_api.domain.category.UniqueFieldValidator;
import cryss.dev.category_api.infraestructure.adapters.repositories.jpa.CategoryRepositorySpringJPA;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;


@RequiredArgsConstructor
public class GenericUniqueFieldValidator implements ConstraintValidator<UniqueField, Object>, Serializable {

    private final List<UniqueFieldValidator> validators;

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return validators.stream ()
                .anyMatch (uniqueFieldValidator -> uniqueFieldValidator.isValid (value));
    }
}
