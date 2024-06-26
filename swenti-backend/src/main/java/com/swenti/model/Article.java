package com.swenti.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Blob;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String publisher;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String site;

    @Column(nullable = false)
    private int views;

}
