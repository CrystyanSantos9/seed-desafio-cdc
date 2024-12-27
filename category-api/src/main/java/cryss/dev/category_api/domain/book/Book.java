package cryss.dev.category_api.domain.book;

import cryss.dev.category_api.domain.author.Author;
import cryss.dev.category_api.domain.category.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openapitools.model.NewBookAuthor;
import org.openapitools.model.NewBookCategory;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book implements Serializable {
    private String title;

    private String synopsis;

    private String summary;

    private BigDecimal price;

    private Long pages;

    private String isbn;

    private LocalDateTime releaseDate;

    private Category category;

    private Author author;
}
