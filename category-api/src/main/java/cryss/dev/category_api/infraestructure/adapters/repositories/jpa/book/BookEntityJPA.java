package cryss.dev.category_api.infraestructure.adapters.repositories.jpa.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cryss.dev.category_api.infraestructure.adapters.repositories.jpa.author.AuthorJPAEntity;
import cryss.dev.category_api.infraestructure.adapters.repositories.jpa.category.CategoryEntityJpa;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "BOOKS")
public class BookEntityJPA implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @Size(max = 500)
    private String synopsis;

    private String summary;

    @Min (value = 20L)
    private BigDecimal price;

    @Min (value = 100L)
    private Long pages;

    @Column(unique = true)
    private String isbn;

    @Future
    private LocalDateTime releaseDate;

//    optional=false relação nao pode ser nula
//    nullable=false poe notnull na chave estrangeira
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categories_id", nullable = false)
//    OnDelectionAction.CASCADE se deleta pai, delta filhos
//    @OnDelete (action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private CategoryEntityJpa category;

    //    optional=false relação nao pode ser nula
//    nullable=false poe notnull na chave estrangeira
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "authors_id", nullable = false)
//    OnDelectionAction.CASCADE se deleta pai, delta filhos
//    @OnDelete (action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private AuthorJPAEntity author;

}
