package me.patrick.laboratory.repository;

import me.patrick.laboratory.finalvalue.entity.masterEntity.MemberMst;
import me.patrick.laboratory.finalvalue.entity.masterEntity.OrderMst;
import me.patrick.laboratory.mvctest.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class OrderMasterRepositoryTest {


    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private MemberMasterRepository memberMasterRepository;

    @Autowired
    private MemberService memberService;

    @Test
    @Transactional
    void test(){

        MemberMst memberMst = memberMasterRepository.findById("MM20220212000003").get(); // 비영속상태 객체

        OrderMst orderMst = OrderMst.builder()
                .paymentBankName("신한")
                .member(memberMst)
                .build();


        orderMasterRepository.saveAndFlush(memberMst);
    }
}