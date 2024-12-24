package cryss.dev.category_api.infraestructure.adapters.repositories.jpa;

import cryss.dev.category_api.domain.category.Category;
import cryss.dev.category_api.domain.category.CategoryRepository;
import cryss.dev.category_api.infraestructure.mappers.CategoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Log4j2
public class CategoryRepositoryJPA implements CategoryRepository {

    private final CategoryMapper mapper;
    private final CategoryRepositorySpringJPA repository;

    @Override
    public CategoryEntityJpa create(Category categoryDomain) {
        log.info ("method={}", "create");
        return repository.save (mapper.toCategoryEntityJPA(categoryDomain));
    }

}
