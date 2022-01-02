package me.patrick.laboratory.memoryleak;

public class OuterClass {
    int o = 10;
    static class Inner {
        int i = 20;
    }
}

class Demo {
    public static void main(String args[]) {
        OuterClass o = new OuterClass();

    }

}