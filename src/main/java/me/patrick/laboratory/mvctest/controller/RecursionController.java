package me.patrick.laboratory.mvctest.controller;

import me.patrick.laboratory.finalvalue.payload.RecursionPayload;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecursionController {

    @GetMapping("/recursion")
    public void recursionTest(@RequestBody RecursionPayload recursionPayload) {

    }
}
