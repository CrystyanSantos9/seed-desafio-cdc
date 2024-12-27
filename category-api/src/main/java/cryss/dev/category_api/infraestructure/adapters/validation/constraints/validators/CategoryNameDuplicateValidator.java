package cryss.dev.category_api.infraestructure.adapters.validation.constraints.validators;

import cryss.dev.category_api.infraestructure.adapters.repositories.jpa.category.CategoryRepositorySpringJPA;
import cryss.dev.category_api.infraestructure.adapters.validation.constraints.annotations.NotDuplicate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class CategoryNameDuplicateValidator implements ConstraintValidator<NotDuplicate, String> {

    private final CategoryRepositorySpringJPA repository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !repository.findCategoryByName(value).isPresent();
    }
}
