package me.patrick.laboratory.mvctest.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.patrick.laboratory.mvctest.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/test/hello")
    public String test() {
        memberService.saveAllTest();
        return "haha";
    }

    @PostMapping("/member")
    public String createUser(){
        memberService.createUser();
        return "success";
    }

    @PostMapping("/order")
    public String createOrder(){
        memberService.createOrder();
        return "success";
    }

}

