package me.patrick.laboratory.mvctest.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.patrick.laboratory.finalvalue.entity.Member;
import me.patrick.laboratory.repository.MemberQueryRepository;
import me.patrick.laboratory.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {

    private final MemberQueryRepository memberQueryRepository;
    private final MemberRepository repository;

    @Transactional
    public String test(){
        Member m = repository.findMemberById(3L);
        m.changeName("울룰루");
        List<Member> members = memberQueryRepository.findMyMember();
        members.forEach(System.out::println);
        return null;
    }

}
