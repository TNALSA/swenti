package com.swenti.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CommentsId implements Serializable {
    @Column(name = "articleid")
    private int articleid;

    @Column(name = "commentid")
    private int commentid;
}
