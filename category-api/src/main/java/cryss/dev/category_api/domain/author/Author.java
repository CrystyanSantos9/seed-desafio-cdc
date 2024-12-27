package cryss.dev.category_api.domain.author;

import org.checkerframework.common.aliasing.qual.Unique;

import java.io.Serializable;
import java.time.LocalDateTime;


public class Author implements Serializable {

    private Long id;

    private String name;
    private String description;
    private String email;
    private LocalDateTime createdAt;

    public Author(Long id, String name, String description, String email, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.email = email;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
