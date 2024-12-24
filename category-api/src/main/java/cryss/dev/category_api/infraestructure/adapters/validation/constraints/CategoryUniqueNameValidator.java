package cryss.dev.category_api.infraestructure.adapters.validation.constraints;

import cryss.dev.category_api.domain.category.UniqueFieldValidator;
import cryss.dev.category_api.infraestructure.adapters.repositories.jpa.CategoryRepositorySpringJPA;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.NewCategory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryUniqueNameValidator implements UniqueFieldValidator {

    private final CategoryRepositorySpringJPA repository;

    @Override
    public Boolean isValid(Object object) {
        NewCategory category = (NewCategory) object;
        return accept (object) && !repository.findCategoryByName (category.getName ()).isPresent ();
    }

    @Override
    public Boolean accept(Object object) {
        return object instanceof NewCategory;
    }

}
