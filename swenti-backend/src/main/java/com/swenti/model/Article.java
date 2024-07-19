package com.swenti.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.*;

import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "article")
public class Article {
    @Id
    //GeneratedValue(strategy = GenerationType.IDENTITY): PK에서만 사용할 수 있는 옵션
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String details;

    @Column(nullable = false)
    private String media;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private String images;

    @Column(nullable = false)
    private String site;

    @Column(nullable = false)
    private int view;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private LocalDateTime writed_date;


}
