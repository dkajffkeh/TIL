package me.patrick.laboratory.cglib.cont;

import org.springframework.stereotype.Service;

@Service
public class TestBeanService {

    private final InnerService innerService;

    public TestBeanService(InnerService innerService) {
        this.innerService = innerService;
    }

    public final void cglibTest() {
        innerService.testMethod();
    }
}
