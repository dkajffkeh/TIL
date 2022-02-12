package me.patrick.laboratory.mvctest.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.patrick.laboratory.finalvalue.entity.masterEntity.MemberMst;
import me.patrick.laboratory.finalvalue.entity.masterEntity.OrderMst;
import me.patrick.laboratory.repository.MemberMasterRepository;
import me.patrick.laboratory.repository.OrderMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {

    private final MemberMasterRepository memberMasterRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Transactional
    public void executor(){

        MemberMst memberMst = memberMasterRepository.findById("MM20220212000003").get();

        OrderMst orderMst = OrderMst.builder()
                .paymentBankName("신한")
                .member(memberMst)
                .build();

        /*orderMasterRepository.save(orderMst);*/

    }

    @Transactional
    public void orderTest(OrderMst orderMst){
        /*orderMasterRepository.save(orderMst);*/
    }

}