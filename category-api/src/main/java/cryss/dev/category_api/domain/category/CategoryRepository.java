package cryss.dev.category_api.domain.category;

import cryss.dev.category_api.infraestructure.adapters.repositories.jpa.category.CategoryEntityJpa;

public interface CategoryRepository {
    CategoryEntityJpa create(Category categoryDomain);

    CategoryEntityJpa findById(Long id);
}
