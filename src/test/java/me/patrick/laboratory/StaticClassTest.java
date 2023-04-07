package me.patrick.laboratory;

public class StaticClassTest {


    public static class StaticClassA /*extends NoneStaticClassB*/ {

    }

    public class NoneStaticClassB {

    }

    interface InterfaceA {
        void testMethod();
    }

    interface InterfaceB {
        void testMethod();
    }

    public static class InterfaceABTest implements InterfaceA, InterfaceB {

        @Override
        public void testMethod() {

        }

    }
}
