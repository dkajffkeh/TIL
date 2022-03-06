package me.patrick.laboratory.javapattern.templatecallback;

import org.junit.jupiter.api.Test;

public class TemplateCallbackPattern {

    // 전략 인터페이스
    @FunctionalInterface
    public interface CarWash{
        void startCarWash();
    }

    public static class DetailingCenter {

        public void startWash(String vendor){
            createInstance(vendor).startCarWash();
        }

        private CarWash createInstance(String vendor){
            return  () -> System.out.println(vendor + "(이/가) 세차를 시작합니다!");
        }
    }

    @Test
    void templateCallback(){
        DetailingCenter detailingCenter = new DetailingCenter();
        detailingCenter.startWash("오토엔");
        detailingCenter.startWash("인스타 워시");
    }

}
