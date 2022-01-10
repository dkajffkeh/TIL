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

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {

    private final TeamRepository teamRepository;
    private final CoachRepository coachRepository;
    private final EntityManager em;
    private final MemberServiceHandler memberHandler;
    private final MemberRepository memberRepository;

    @Transactional
    public Member createMember(){
        return memberRepository.findMemberById(3L);
    }
}