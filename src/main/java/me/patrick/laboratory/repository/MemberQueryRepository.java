package me.patrick.laboratory.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@RequiredArgsConstructor
@Slf4j
@Repository
public class MemberQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;
    @PersistenceContext
    private final EntityManager entityManager;



}
