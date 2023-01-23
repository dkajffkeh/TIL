package me.patrick.laboratory.immutable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImmutableObjectTest {

    private static final Logger log = LoggerFactory.getLogger(ImmutableObjectTest.class);

    @Test
    @DisplayName("참조 투명한 객체")
    void immutableTest() {
        String x = "Hello";
        String v1 = x + "World";
        Assertions.assertEquals("HelloWorld",v1);
    }

    @Test
    @DisplayName("참조 투명하지 않은 객체")
    void mutableTest() {
        StringBuilder x = new StringBuilder("World");
        String v1 = x.append("Hello").toString();
        System.out.println(x);
    }


}
