package me.patrick.laboratory.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.patrick.laboratory.finalvalue.entity.masterEntity.MemberMst;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static me.patrick.laboratory.finalvalue.entity.masterEntity.QMemberMst.memberMst;


@RequiredArgsConstructor
@Slf4j
@Repository
public class MemberQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;
    @PersistenceContext
    private final EntityManager entityManager;

    @EntityGraph(value = "MemberMstEntities", type = EntityGraphType.LOAD)
    public List<MemberMst> findAllMembers(){

        return jpaQueryFactory
                .selectFrom(memberMst)
                .fetch();

    }

}
