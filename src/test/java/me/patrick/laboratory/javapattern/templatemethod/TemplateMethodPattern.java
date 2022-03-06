package me.patrick.laboratory.javapattern.templatemethod;

import org.junit.jupiter.api.Test;

public class TemplateMethodPattern {

    public static abstract class CarWash{

        // 훅 메서드, 오버라이딩을 할 수 있고 그대로 사용할 수 있다.
        protected void wheelClean(){
            System.out.println("바퀴 세척 로직");
        }

        // 추상 메서드, 오버라이딩 강제함
        abstract void detailing();

        // 견본 메서드
        public void carWash(){
            wheelClean();
            detailing();
        }
    }

    public static class Auton extends CarWash{
        @Override
        void detailing() {
            System.out.println("오토앤 내무 세차");
        }
    }

    @Test
    void templateMethodPattern(){
        Auton auton = new Auton();
        auton.carWash();
    }

}
