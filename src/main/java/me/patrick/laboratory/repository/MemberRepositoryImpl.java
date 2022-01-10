package me.patrick.laboratory.repository;

import me.patrick.laboratory.finalvalue.entity.Member;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class MemberRepositoryImpl extends QuerydslRepositorySupport implements MemberCustomRepository{

    public MemberRepositoryImpl() {super(Member.class);}

    /*@Override
    public Member findMemberById(Long id) {

        return from(QMember.member)
                .where(
                        QMember.member.id.eq(id)
                ).fetchFirst();
    }*/
}
