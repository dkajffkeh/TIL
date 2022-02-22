package me.patrick.laboratory.repository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

import static me.patrick.laboratory.finalvalue.entity.masterEntity.QMemberMst.memberMst;
import static me.patrick.laboratory.finalvalue.entity.masterEntity.QOrderMst.orderMst;

@Slf4j
@RequiredArgsConstructor
@Repository
public class OrderQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<Tuple> findByOrderAndMember() {

        return jpaQueryFactory.select(orderMst, memberMst)
                .from(orderMst)
                .join(orderMst.member, memberMst)
                .where(
                        orderMst.member.memberMstId.eq("MM20220212000003"))
                .fetch();
    }
}
