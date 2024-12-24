package cryss.dev.application.adapters.controller;

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
public class CategoryController implements CategoryApi {
    @Override
    public ResponseEntity<CategoryResponse> create(NewCategory newCategory) {
        return CategoryApi.super.create (newCategory);
    }
}
