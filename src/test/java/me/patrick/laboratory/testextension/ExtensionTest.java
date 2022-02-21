package me.patrick.laboratory.testextension;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.RegisterExtension;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExtensionTest {

    @RegisterExtension
    static FindSlowTestExtension findSlowTestExtension = new FindSlowTestExtension(1000L);

    @Test
    @Order(1)
    void test() throws InterruptedException {
        Thread.sleep(1005L);
        System.out.println("진행");
    }

}
