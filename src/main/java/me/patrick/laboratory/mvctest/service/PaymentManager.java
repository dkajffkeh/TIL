package me.patrick.laboratory.mvctest.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentManager {

    private final PaymentService paymentService;

    public void rollbackTest(){
        try {
            paymentService.createPayment();
        } catch (Exception e){
            log.info("Exception");
        }
    }
}
