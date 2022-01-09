package me.patrick.laboratory.mvctest.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.patrick.laboratory.mvctest.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@AllArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/test/hello")
    public String test()  {
        return "haha";
    }
    @GetMapping("/member")
    public void createUser(){
        memberService.createMember();
    }

    @GetMapping("/members")
    public String getMembers()  {
        return null;
    }

    @GetMapping("/cascade")
    public void cascade(){
    }

    @GetMapping("/thread/local/{thread}")
    public void threadLocal(@PathVariable String thread){
    }

    @GetMapping("/member/trans/test")
    public void memberTrans(){}

    @GetMapping("/trans/test")
    public void transTest() throws IOException {
    }
}

