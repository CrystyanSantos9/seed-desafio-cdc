package cryss.dev.category_api.infraestructure.adapters.repositories.jpa.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepositorySpringJPA extends JpaRepository<CategoryEntityJpa, Long> {
    @Query("select c from CategoryEntityJpa c where c.name = ?1")
    Optional<Boolean> findCategoryByName(String value);

    Optional<CategoryEntityJpa> findById(Long id);
}
