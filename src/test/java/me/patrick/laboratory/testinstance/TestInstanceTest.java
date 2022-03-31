package me.patrick.laboratory.testinstance;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class
TestInstanceTest {

    int test = 1;

    @Test
    void test() {
        System.out.println(test++);
    }

    @Test
    void test2() {
        System.out.println(test++);
    }
}
