package me.patrick.laboratory.cglib.cont;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cglib")
public class TestController {

    private final TestBeanService testBeanService;

    public TestController(TestBeanService testBeanService) {
        this.testBeanService = testBeanService;
    }

    @GetMapping
    public void testMethod() {
        testBeanService.cglibTest();
    }
}
