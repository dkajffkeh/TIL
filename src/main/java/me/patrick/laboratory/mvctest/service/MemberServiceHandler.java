package me.patrick.laboratory.mvctest.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.patrick.laboratory.finalvalue.entity.Member;
import me.patrick.laboratory.repository.CoachRepository;
import me.patrick.laboratory.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class MemberServiceHandler {

    private final
    MemberRepository memberRepository;
    private final
    CoachRepository coachRepository;

    @Transactional
    public void saveMember(Member m){
        m.changeName("Cellar");
    }

    @Transactional
    public void otherBusiness(){
        log.info("멤버와 상관없는 비즈니스로직");
    }
}
