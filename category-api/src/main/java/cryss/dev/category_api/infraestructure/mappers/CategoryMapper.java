package cryss.dev.category_api.infraestructure.mappers;

import cryss.dev.category_api.domain.category.Category;
import cryss.dev.category_api.infraestructure.adapters.repositories.jpa.CategoryEntityJpa;
import org.mapstruct.Mapper;
import org.openapitools.model.CategoryResponse;
import org.openapitools.model.NewCategory;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "Spring")
public interface CategoryMapper {

    Category toCategoryDomain(NewCategory newCategory);

    CategoryEntityJpa toCategoryEntityJPA(Category categoryDomain);

    CategoryResponse toCategoryResponse(CategoryEntityJpa categoryEntityJpa);
}
