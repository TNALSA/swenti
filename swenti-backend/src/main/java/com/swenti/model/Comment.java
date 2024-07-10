package com.swenti.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Reference;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @NonNull
    private int articleid;

    @NonNull
    @Column(nullable = false)
    private int commentid;

    @Column(nullable = false)
    private int commentlevel;

    @NonNull
    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private LocalDateTime date = LocalDateTime.now();

    @NonNull
    @Column(nullable = false)
    private String details;
}
