package me.patrick.laboratory.mvctest.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.patrick.laboratory.finalvalue.entity.masterEntity.MemberMst;
import me.patrick.laboratory.finalvalue.entity.masterEntity.OrderMst;
import me.patrick.laboratory.repository.MemberMasterRepository;
import me.patrick.laboratory.repository.OrderMasterRepository;
import me.patrick.laboratory.teststatic.TestStaticClass;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {

    private final MemberMasterRepository memberMasterRepository;
    private final OrderMasterRepository orderMasterRepository;

    private final MemberServiceHandler memberServiceHandler;

    public Integer test() {
        return TestStaticClass.test(1, 2);
    }

    public void saveAllTest() {
        List<MemberMst> members = memberMasterRepository.findAll();

        members.forEach(it -> it.plusAge(1));

        memberMasterRepository.saveAll(members);
    }

    public void createUser() {
        MemberMst m = new MemberMst("유호연",30);
        memberMasterRepository.save(m);
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