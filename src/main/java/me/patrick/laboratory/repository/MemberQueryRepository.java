package me.patrick.laboratory.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.patrick.laboratory.finalvalue.entity.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

import static me.patrick.laboratory.finalvalue.entity.QMember.member;

@Slf4j
@RequiredArgsConstructor
@Repository
public class MemberQueryRepository {

    private final JPAQueryFactory queryFactory;
    public List<Member> findMyMember(){
        return queryFactory.selectFrom(member).fetch();
    }
}
