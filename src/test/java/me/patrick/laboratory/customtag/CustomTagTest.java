package me.patrick.laboratory.customtag;

public class CustomTagTest {

    @CustomTestAnnotation
    void customTag() {
        System.out.println("test");
    }
}
