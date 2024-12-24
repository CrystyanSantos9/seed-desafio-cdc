package cryss.dev.category_api.application.adapters.controller;

import cryss.dev.category_api.domain.category.ServiceCategory;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.openapitools.api.CategoryApi;
import org.openapitools.model.CategoryResponse;
import org.openapitools.model.NewCategory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Log4j2
@RequiredArgsConstructor
public class CategoryController implements CategoryApi {

private final ServiceCategory service;

    @Override
    public ResponseEntity<CategoryResponse> create(NewCategory newCategory) {
        return ResponseEntity.ok (service.create (newCategory));
    }
}
