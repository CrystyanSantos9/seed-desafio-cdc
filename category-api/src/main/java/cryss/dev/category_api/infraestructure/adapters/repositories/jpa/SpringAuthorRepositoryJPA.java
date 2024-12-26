package cryss.dev.category_api.infraestructure.adapters.repositories.jpa;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringAuthorRepositoryJPA extends JpaRepository<AuthorJPAEntity, Long> {
    @Query(value = "SELECT a FROM AuthorJPAEntity a WHERE a.email = ?1")
    Optional<Boolean> findAuthorByEmail(String value);

    @Query(value = "SELECT a FROM AuthorJPAEntity a WHERE a.name = ?1")
    Optional<Boolean> findAuthorByName(@NotNull String name);

}
