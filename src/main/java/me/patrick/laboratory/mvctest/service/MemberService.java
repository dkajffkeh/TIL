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

    @Autowired
    private MemberMasterRepository memberMasterRepository;

    @Autowired
    private MemberService memberService;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

        /*@Transactional*/
    @Transactional
    public void executor(){
        MemberMst member = memberMasterRepository.findById(1L).get();

        OrderMst orderMst = OrderMst.builder()
                .member(member)
                .paymentBankName("신한")
                .build();

        orderMasterRepository.save(orderMst);
    }

}