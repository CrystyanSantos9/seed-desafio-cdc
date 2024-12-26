package cryss.dev.category_api.infraestructure.adapters.validation.constraints;

import cryss.dev.category_api.domain.category.UniqueFieldValidator;
import cryss.dev.category_api.infraestructure.adapters.repositories.jpa.CategoryRepositorySpringJPA;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;

import java.io.Serializable;
import java.util.List;


@RequiredArgsConstructor
public class GenericUniqueFieldValidator implements ConstraintValidator<UniqueFieldName, Object>, Serializable {

    private final List<UniqueFieldValidator> validators;

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        var validator =  validators.stream ()
                .filter(uniqueFieldValidator -> uniqueFieldValidator.accept (value))
                .map (uniqueFieldValidator -> uniqueFieldValidator.isValid (value))
                .toList ();

        return ObjectUtils.isNotEmpty (validator) ? validator.get (0): Boolean.TRUE;
    }
}
