package me.patrick.laboratory.mvctest.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
@ToString
@RequiredArgsConstructor
public class PaymentParam {

    private Long orderId;
    private int productPrice;

}
