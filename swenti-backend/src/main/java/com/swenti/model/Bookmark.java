package com.swenti.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "bookmark")
public class Bookmark {
    @Id
    private int id;

    @NonNull
    @Column(nullable = false)
    private int articleid;

    @NonNull
    @Column(nullable = false)
    private String userid;
}
