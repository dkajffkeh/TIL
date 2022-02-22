package me.patrick.laboratory.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.patrick.laboratory.finalvalue.entity.masterEntity.MemberMst;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static me.patrick.laboratory.finalvalue.entity.masterEntity.QMemberMst.memberMst;
import static me.patrick.laboratory.finalvalue.entity.masterEntity.QOrderMst.orderMst;


@RequiredArgsConstructor
@Slf4j
@Repository
public class MemberQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;
    @PersistenceContext
    private final EntityManager entityManager;

    public List<MemberMst> findAllMembers() {
        return jpaQueryFactory.selectFrom(memberMst).fetch();
    }

    public void updateMember() {
        jpaQueryFactory.update(memberMst)
                .set(memberMst.username, "Changed")
                .execute();
        entityManager.flush();
        entityManager.clear();
    }

    public List<MemberMst> findMemberAndOrder() {

        return jpaQueryFactory
                .selectFrom(memberMst)
                .join(memberMst.orders, orderMst).fetchJoin()
                .where(memberMst.memberMstId.eq("MM20220212000003"))
                .fetch();


    }

}
