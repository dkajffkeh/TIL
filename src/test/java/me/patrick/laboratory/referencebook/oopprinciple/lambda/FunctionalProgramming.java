package me.patrick.laboratory.referencebook.oopprinciple.lambda;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionalProgramming {

    @Test
    @DisplayName("기본 방식의 코드 블럭")
    void caseOne(){
        MyInterface myInterface = new MyInterface() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        };
        myInterface.run();
    }

    @Test
    @DisplayName("람다 코드 블럭")
    void caseTwo(){
        MyInterface myInterface = () -> System.out.println("Hello World");
        myInterface.run();
    }

    @Test
    @DisplayName("파라미터가 있는 함수형 인터페이스 사용")
    void caseThree(){
        MyParameterInterface myParameterInterface = (int a) -> a;

        int result = myParameterInterface.run(10);
        System.out.println(result);
    }

    @Test
    @DisplayName("람다식 참조변수 사용")
    void caseFour(){
        MyParameterInterface myParameterInterface = (int a) -> a;
        doIt(myParameterInterface);
    }

    @Test
    @DisplayName("람다 참조변수 메소드 이용케이스")
    void caseFive(){
        doIt((int a) -> a);
    }

    private void doIt(MyParameterInterface myParameterInterface){
        System.out.println(myParameterInterface.run(50));
    }

    // API 제공형 함수형 인터페이스
    @Test
    @DisplayName("Supplier<T>")
    void supplierTest(){
        Supplier<Integer> integerSupplier = () -> 10*5;
        System.out.println(integerSupplier.get());
    }

    @Test
    @DisplayName("Consumer<T>")
    void consumerTest(){
        Consumer<Integer> integerConsumer = number -> System.out.println("무언가를 save 하는 로직"+ number);
        integerConsumer.accept(50);
    }

    @Test
    @DisplayName("Function<T, R>")
    void functionTest(){
        Function<Integer, String> function = integer -> integer+"";
        String result = function.apply(50);
    }

    @FunctionalInterface
    public interface MyInterface{
        void run();
        default void add(){
            System.out.println("Hello Default World");
        }
    }

    @FunctionalInterface
    public interface MyParameterInterface{
        int run(int a);
    }
}
