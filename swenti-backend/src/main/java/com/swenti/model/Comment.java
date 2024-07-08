package com.swenti.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Reference;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Reference
    private int articleid;

    @Column(nullable = false)
    private int commentid;

    @Column(nullable = false)
    private int commentlevel;

    @Reference
    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private String details;

//    @ManyToOne
//    @JoinColumn(name = "article_id")
//    private Article article;

    public Comment(int articleid, int commentid,String writer, String comment) {
        this.articleid = articleid;
        this.commentid = commentid;
        this.details = comment;
        this.writer = writer;
    }
}
