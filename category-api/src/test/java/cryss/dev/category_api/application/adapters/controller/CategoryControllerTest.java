package cryss.dev.category_api.application.adapters.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import cryss.dev.category_api.domain.category.ServiceCategory;
import cryss.dev.category_api.infraestructure.adapters.repositories.jpa.CategoryRepositorySpringJPA;
import cryss.dev.category_api.infraestructure.adapters.validation.constraints.CategoryNameDuplicateValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.openapitools.model.CategoryResponse;
import org.openapitools.model.NewCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategoryController.class)
class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private ServiceCategory service;

    @MockBean
    private CategoryNameDuplicateValidator validator;

    @MockBean private CategoryRepositorySpringJPA categoryRepositorySpringJPA;

    private MockHttpServletRequest request;

    @BeforeEach
    public void setup(){
        this.request = new MockHttpServletRequest ();
        this.request.setScheme("http");
        this.request.setServerName("localhost");
        this.request.setServerPort(-1);
        this.request.setRequestURI("/");
        this.request.setContextPath("/v1/api");
    }


    @Test
    void createSuccesfull() throws Exception {

        //Arrange/Given
        NewCategory category = new NewCategory("Julia");
        CategoryResponse categoryResponse =CategoryResponse.builder ()
                .name ("Julia")
                .build ();

        BDDMockito.given (service.create(any(NewCategory.class))).willReturn (categoryResponse);


        // When /Act
        ResultActions response =
                mockMvc
                        .perform (post ("/category")
                                .contentType (MediaType.APPLICATION_JSON)
                                .content (mapper.writeValueAsString (category)));

        // Then /Assert
        response.andDo (print ())
                .andExpect (status ().isOk ())
                .andExpect (jsonPath ("$.name", is (categoryResponse.getName ())));

    }

    @Test
    void createFail() throws Exception {

        //Arrange/Given
        NewCategory category = new NewCategory("Julia");
        CategoryResponse categoryResponse =CategoryResponse.builder ()
                .name ("Julia")
                .build ();

        when (categoryRepositorySpringJPA.findCategoryByName (anyString ())).thenReturn (Optional.of (Boolean.TRUE));
        BDDMockito.given (service.create(any(NewCategory.class))).willReturn (categoryResponse);


        // When /Act
        ResultActions response =
                mockMvc
                        .perform (post ("/category")
                                .contentType (MediaType.APPLICATION_JSON)
                                .content (mapper.writeValueAsString (category)));

        // Then /Assert
        response.andDo (print ())
                .andExpect (status ().isBadRequest ());

    }
}