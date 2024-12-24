package cryss.dev.category_api.infraestructure.adapters.repositories.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "CATEGORIES",
indexes = {@Index (name = "index_name", columnList = "name", unique = true)})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryEntityJpa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

}
