package com.swenti.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Reference;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "comments")
public class Comment implements Serializable {
//    @Id
//    @NonNull
//    private int articleid;
//
//    @Id
//    @NonNull
//    @Column(nullable = false)
//    private int commentid;
    @NonNull
    @EmbeddedId
    private CommentsId id;

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
