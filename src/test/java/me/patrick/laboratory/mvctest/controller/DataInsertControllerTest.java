package me.patrick.laboratory.mvctest.controller;

import me.patrick.laboratory.finalvalue.entity.masterEntity.MemberMst;
import me.patrick.laboratory.repository.MemberQueryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DataInsertControllerTest {

    @Autowired
    private DataInsertController dataInsertController;

    @Autowired
    private MemberQueryRepository memberQueryRepository;

    @Test
    void test() {
      /*  List<MemberMst> memberMstList = dataInsertController.dataInsert();
        System.out.println("Done");*/
    }

    @Test
    void nPlusOneTest(){

        List<MemberMst> members = memberQueryRepository.findAllMembers();
        System.out.println("Done");

    }
}