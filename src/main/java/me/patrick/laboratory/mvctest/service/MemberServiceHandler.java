package me.patrick.laboratory.mvctest.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.patrick.laboratory.finalvalue.entity.Member;
import me.patrick.laboratory.repository.CoachRepository;
import me.patrick.laboratory.repository.MemberRepository;
import me.patrick.laboratory.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class MemberServiceHandler {

    private final
    MemberRepository memberRepository;
    private final
    TeamRepository teamRepository;
    private final
    CoachRepository coachRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveMember(Member m){
        m.changeName("차명섭");
        memberRepository.save(m);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void changeName(){
        Member member = memberRepository.findMemberById(14L);
        member.changeName("울룰루");
    }
}
