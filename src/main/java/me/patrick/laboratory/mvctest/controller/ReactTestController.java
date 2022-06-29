package me.patrick.laboratory.mvctest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ReactTestController {

    @GetMapping("/")
    public String reactTest() {
        return "Hello Axios";
    }
}
