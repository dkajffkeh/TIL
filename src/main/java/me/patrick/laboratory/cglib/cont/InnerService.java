package me.patrick.laboratory.cglib.cont;

import org.springframework.stereotype.Service;

@Service
public class InnerService {

    public void testMethod() {
        System.out.println("Hello Cglib");
    }
}
