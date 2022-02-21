package me.patrick.laboratory.testrow;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestRow {

    @Order(1)
    @Test
    void firstTest(){
        System.out.println("first Test");
    }

    @Order(2)
    @Test
    void secondTest(){
        System.out.println("second Test");
    }

    // 같은 숫자 주지 말자.


}
