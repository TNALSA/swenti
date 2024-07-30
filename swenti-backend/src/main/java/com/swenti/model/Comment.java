package com.swenti.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Reference;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@IdClass(CommentPK.class)
@Table(name = "comments")
public class Comment implements Serializable {
    @Id
    @NonNull
    private int articleid;

    @Id
    @NonNull
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
