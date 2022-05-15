package me.patrick.laboratory.mvctest.service;

import lombok.extern.slf4j.Slf4j;
import me.patrick.laboratory.finalvalue.entity.masterEntity.MemberMst;
import me.patrick.laboratory.finalvalue.entity.masterEntity.OrderMst;
import me.patrick.laboratory.repository.MemberMasterRepository;
import me.patrick.laboratory.repository.OrderMasterRepository;
import me.patrick.laboratory.teststatic.TestStaticClass;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class MemberService {

    private final MemberMasterRepository memberMasterRepository;
    private final OrderMasterRepository orderMasterRepository;

    public MemberService(MemberMasterRepository memberMasterRepository, OrderMasterRepository orderMasterRepository) {
        assert memberMasterRepository != null;
        assert orderMasterRepository != null;
        this.memberMasterRepository = memberMasterRepository;
        this.orderMasterRepository = orderMasterRepository;
    }



    public Integer test() {
        return TestStaticClass.test(1, 2);
    }

    public void createUser() {
        MemberMst memberMst = MemberMst.builder()
                .username("유호연")
                .age(32)
                .build();
        memberMasterRepository.save(memberMst);
    }

    @Transactional
    public void createOrder(){
        MemberMst memberMst = memberMasterRepository.findById(1L).get();
        OrderMst orderMst = OrderMst.builder()
                .paymentBankName("신한")
                .member(memberMst).build();
        orderMasterRepository.save(orderMst);

    }
}