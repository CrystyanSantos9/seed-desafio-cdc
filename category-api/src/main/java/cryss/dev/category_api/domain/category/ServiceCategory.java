package cryss.dev.category_api.domain.category;

import org.openapitools.model.CategoryResponse;
import org.openapitools.model.NewCategory;

public interface ServiceCategory {

    CategoryResponse create(NewCategory newCategory);

}
