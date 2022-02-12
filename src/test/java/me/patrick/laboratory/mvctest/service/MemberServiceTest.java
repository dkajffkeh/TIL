package me.patrick.laboratory.mvctest.service;

import me.patrick.laboratory.finalvalue.entity.masterEntity.MemberMst;
import me.patrick.laboratory.finalvalue.entity.masterEntity.OrderMst;
import me.patrick.laboratory.repository.MemberMasterRepository;
import me.patrick.laboratory.repository.OrderMasterRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class MemberServiceTest {

    @Autowired
    private MemberMasterRepository memberMasterRepository;

    @Autowired
    private MemberService memberService;

    @Autowired
    private OrderMasterRepository orderMasterRepository;


    @Test
    /*@Transactional*/
    void executor(){

        MemberMst member = memberMasterRepository.findById(1L).get();

        OrderMst orderMst = OrderMst.builder()
                .member(member)
                .paymentBankName("신한")
                .build();

        orderMasterRepository.save(orderMst);

    }

}