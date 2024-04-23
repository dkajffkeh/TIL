package me.patrick.laboratory.mvctest.service;

import static me.patrick.laboratory.common.type.OrderStatus.PROGRESS;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.patrick.laboratory.finalvalue.entity.masterEntity.MemberMst;
import me.patrick.laboratory.finalvalue.entity.masterEntity.OrderMst;
import me.patrick.laboratory.repository.MemberMasterRepository;
import me.patrick.laboratory.repository.OrderMasterRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {

    private final MemberMasterRepository memberMasterRepository;
    private final OrderMasterRepository orderMasterRepository;

    private final MemberServiceHandler memberServiceHandler;

    @Transactional
    public void selectTest1() {
        OrderMst orderMst = orderMasterRepository.findById(1L);
        log.info(orderMst.toString());
        orderMst.processDone();
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void selectTest2() {
        OrderMst orderMst = orderMasterRepository.findById(1L);
        if(orderMst.getOrderStatus() == PROGRESS) {
            log.info("결제");
        }
    log.info(orderMst.toString());
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public final Long createUser() {
        MemberMst m = MemberMst.of();
        memberMasterRepository.save(m);
        return m.getId();
    }

    @Transactional
    public void memberModifyTest() {
        MemberMst m = memberMasterRepository.findById(18L).get();
        memberServiceHandler.memberModifyTest();
        m.changeName("유호연");
    }

    @Transactional
    public void npoTestHandler(Pageable pageable) {
        Page<MemberMst> members = memberMasterRepository.findAll(pageable);
        members.getContent().forEach(mem -> log.info(mem.getOrders().toString()));
    }

    @Transactional
    public void createOrder(){
        MemberMst memberMst = memberMasterRepository.findById(1L).get();
        OrderMst orderMst = OrderMst.builder()
                .paymentBankName("신한")
                .member(memberMst).build();

    }
}
