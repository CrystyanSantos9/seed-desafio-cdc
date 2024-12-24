package cryss.dev.category_api.domain.category;

import cryss.dev.category_api.infraestructure.adapters.repositories.jpa.CategoryEntityJpa;

public interface CategoryRepository {
    CategoryEntityJpa create(Category categoryDomain);
}
