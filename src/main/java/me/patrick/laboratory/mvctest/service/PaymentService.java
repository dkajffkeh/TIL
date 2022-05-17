package me.patrick.laboratory.mvctest.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.patrick.laboratory.common.type.OrderStatus;
import me.patrick.laboratory.finalvalue.entity.masterEntity.OrderMst;
import me.patrick.laboratory.finalvalue.entity.masterEntity.PaymentMst;
import me.patrick.laboratory.mvctest.controller.PaymentParam;
import me.patrick.laboratory.repository.OrderMasterRepository;
import me.patrick.laboratory.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;

import static java.lang.Thread.sleep;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderMasterRepository orderMasterRepository;

    @Transactional
    public void createPayment(PaymentParam paymentParam){
        OrderMst orderMst = orderMasterRepository.findById(paymentParam.getOrderId()).get();


        if (orderMst.getOrderStatus() == OrderStatus.DONE) return;


        PaymentMst paymentMst = PaymentMst.builder()
                .order(orderMst)
                .productPrice(paymentParam.getProductPrice())
                .build();

        paymentRepository.save(paymentMst);
        processPayment();
        orderMst.processDone();
    }

    public void processPayment(){
        try {
            sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void createPayment(){
        OrderMst orderMst = orderMasterRepository.findById(2L).get();
        PaymentMst paymentMst = PaymentMst.builder()
                .order(orderMst)
                .productPrice(4000)
                .build();

        paymentRepository.save(paymentMst);

        throw new ResourceAccessException("ResourceAccessException");
    }
}
