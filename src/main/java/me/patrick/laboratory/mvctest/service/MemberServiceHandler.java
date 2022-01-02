package me.patrick.laboratory.mvctest.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.patrick.laboratory.repository.CoachRepository;
import me.patrick.laboratory.repository.MemberRepository;
import me.patrick.laboratory.repository.TeamRepository;
import org.springframework.stereotype.Service;

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


}
