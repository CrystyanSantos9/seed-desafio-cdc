package cryss.dev.author_api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Author {
    private String name;
    private String description;
    private String email;
    private LocalDateTime createdAt;
}
