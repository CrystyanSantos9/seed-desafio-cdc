package cryss.dev.category_api.infraestructure.adapters.repositories.jpa.category;

import cryss.dev.category_api.domain.category.Category;
import cryss.dev.category_api.domain.category.CategoryRepository;
import cryss.dev.category_api.infraestructure.exception.BusinessException;
import cryss.dev.category_api.infraestructure.mappers.CategoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;

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

    @Override
    public CategoryEntityJpa findById(Long id) {
        return repository.findById (id).orElseThrow (()->
            BusinessException.builder ()
                    .httpStatusCode (org.springframework.http.HttpStatus.BAD_REQUEST)
                    .code (String.valueOf (HttpStatus.SC_BAD_REQUEST))
                    .message ("Not found.")
                    .description (String.format ("CategoryId=%s not found.", id))
                    .build ()
        );
    }

}
