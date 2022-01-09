package me.patrick.laboratory.mvctest.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.patrick.laboratory.finalvalue.entity.Member;
import me.patrick.laboratory.repository.CoachRepository;
import me.patrick.laboratory.repository.MemberRepository;
import me.patrick.laboratory.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;
    private final CoachRepository coachRepository;
    private final EntityManager em;
    private final MemberServiceHandler memberHandler;

    @Transactional
    public void createMember(){
        Optional<Member> memberOptional = memberRepository.findById(14L);

        if(memberOptional.isPresent()) log.info("없음");

        Member m = Member.builder()
                .id(14L)
                .age(32)
                .username("유호연")
                .build();

        memberHandler.saveMember(m);

        try {

            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}