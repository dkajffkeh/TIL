package me.patrick.laboratory.repository;

import me.patrick.laboratory.finalvalue.entity.masterEntity.MemberMst;
import me.patrick.laboratory.mvctest.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class OrderMasterRepositoryTest {


    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private MemberMasterRepository memberMasterRepository;

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberQueryRepository memberQueryRepository;

    @Autowired
    private OrderQueryRepository orderQueryRepository;

    @Test
    @Transactional
    void test(){

        List<MemberMst> tupleList = memberQueryRepository.findMemberAndOrder();
        tupleList.forEach(System.out::println);
        System.out.println(tupleList.get(0).getOrders().toString());

    }
}