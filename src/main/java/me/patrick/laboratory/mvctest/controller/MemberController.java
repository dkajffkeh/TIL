package me.patrick.laboratory.mvctest.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.patrick.laboratory.mvctest.service.MemberService;
import org.springframework.data.domain.Pageable;
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
        memberService.selectTest1();
        return "haha";
    }

    @GetMapping("/test/hello/1")
    public String test1() {
        memberService.selectTest2();
        return "haha";
    }

    @GetMapping("/npo/test")
    public void npoTest(final Pageable pageable) {
        memberService.npoTestHandler(pageable);
    }

    @PostMapping("/member")
    public Long createUser(){
        return memberService.createUser();
    }

    @PostMapping("/member/modify")
    public void osivTest() {
        memberService.memberModifyTest();
    }

    @PostMapping("/order")
    public String createOrder(){
        memberService.createOrder();
        return "success";
    }

}

