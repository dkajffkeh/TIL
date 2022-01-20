package me.patrick.laboratory.mvctest.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.patrick.laboratory.finalvalue.entity.Member;
import me.patrick.laboratory.repository.MemberQueryRepository;
import me.patrick.laboratory.repository.MemberRepository;
import me.patrick.laboratory.repository.TeamRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {

    private final MemberQueryRepository memberQueryRepository;
    private final MemberRepository repository;
    private final MemberServiceHandler handler;
    private final TeamRepository teamRepository;




    public String test(){
        Member m = repository.findMemberById(3L);
        handler.saveMember(m);
        m.changeName("Patrick");
        handler.otherBusiness();
        return null;
    }

}
