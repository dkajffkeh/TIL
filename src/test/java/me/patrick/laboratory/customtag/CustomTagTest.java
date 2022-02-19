package me.patrick.laboratory.customtag;

import org.junit.jupiter.api.Tag;

public class CustomTagTest {

    @CustomTestAnnotation
    void customTag(){
        System.out.println("test");
    }
}
