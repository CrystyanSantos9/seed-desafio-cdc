package cryss.dev.category_api.application.adapters.services;

import cryss.dev.category_api.domain.category.CategoryRepository;
import cryss.dev.category_api.domain.category.ServiceCategory;
import cryss.dev.category_api.infraestructure.mappers.CategoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.openapitools.model.CategoryResponse;
import org.openapitools.model.NewCategory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class CreateCategory implements ServiceCategory {

    private final CategoryMapper mapper;
    private final CategoryRepository repository;

    @Override
    public CategoryResponse create(NewCategory newCategory) {
        log.info ("method={}, input={}", "create", newCategory);
        var domain = mapper.toCategoryDomain(newCategory);
        var dto = mapper.toCategoryResponse(repository.create (domain));
        return dto;
    }

}
