package me.patrick.laboratory.mvctest.service;

import lombok.extern.slf4j.Slf4j;
import me.patrick.laboratory.repository.CoachRepository;
import me.patrick.laboratory.repository.MemberRepository;
import me.patrick.laboratory.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
@Slf4j
public class MemberService {


    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private CoachRepository coachRepository;
    @Autowired
    private EntityManager em;
    private final int batchSize = 10000;

}