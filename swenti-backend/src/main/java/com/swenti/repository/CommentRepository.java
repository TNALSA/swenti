package com.swenti.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommentRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public void writeComment(){

    }
}
