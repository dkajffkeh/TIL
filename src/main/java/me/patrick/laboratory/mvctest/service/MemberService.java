package me.patrick.laboratory.mvctest.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.patrick.laboratory.finalvalue.entity.masterEntity.MemberMst;
import me.patrick.laboratory.finalvalue.entity.masterEntity.OrderMst;
import me.patrick.laboratory.repository.MemberMasterRepository;
import me.patrick.laboratory.repository.OrderMasterRepository;
import me.patrick.laboratory.teststatic.TestStaticClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
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

    public Long createUser() {
        MemberMst m = MemberMst.of();
        memberMasterRepository.save(m);
        return m.getId();
    }

    @Transactional
    public void npoTestHandler(Pageable pageable) {
        Page<MemberMst> members = memberMasterRepository.findAll(pageable);

        members.getContent().forEach(mem -> {
            log.info(mem.getOrders().toString());
        });
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