package me.patrick.laboratory.mvctest.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.patrick.laboratory.finalvalue.masterEntity.MemberMst;
import me.patrick.laboratory.repository.MemberQueryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {

    private final MemberQueryRepository memberQueryRepository;

    @Transactional
    public void updateMember(){

        List<MemberMst> members = memberQueryRepository.findAllMembers();

        memberQueryRepository.updateMember();
        log.info("실행완료");

        List<MemberMst> membersAfterUpdate = memberQueryRepository.findAllMembers();
        membersAfterUpdate.forEach(System.out::println);

        membersAfterUpdate.get(0).changeAge(55);

    }

}