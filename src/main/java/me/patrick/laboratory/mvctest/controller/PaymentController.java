package me.patrick.laboratory.mvctest.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.patrick.laboratory.mvctest.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/payment")
    public synchronized String createPayment(@RequestBody PaymentParam paymentParam){
        paymentService.createPayment(paymentParam);
        return "success";
    }
}
