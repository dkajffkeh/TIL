package me.patrick.laboratory.member;

import me.patrick.laboratory.finalvalue.entity.masterEntity.MemberMst;
import me.patrick.laboratory.repository.MemberMasterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class MemberMstTest {

    @Autowired
    private MemberMasterRepository memberMasterRepository;

    @BeforeEach
    public void beforeAction() {
        List<MemberMst> members = Arrays.asList(
                new MemberMst("홍지운",30),
                new MemberMst("김종구",30),
                new MemberMst("유호연",32)
        );

        memberMasterRepository.saveAll(members);
    }

    @Test
    @DisplayName("findAll 테스트")
    void findAllTest() {

        List<MemberMst> members = memberMasterRepository.findAll();

        members.forEach(it -> it.plusAge(1));

        memberMasterRepository.saveAll(members);

        List<MemberMst> membersAfterProcessing = memberMasterRepository.findAll();

    }
}
