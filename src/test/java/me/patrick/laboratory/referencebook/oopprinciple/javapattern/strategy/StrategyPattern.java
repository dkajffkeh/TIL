package me.patrick.laboratory.referencebook.oopprinciple.javapattern.strategy;

import org.junit.jupiter.api.Test;

public class StrategyPattern {

    // 전략 인터페이스
    public interface CarWash{
        void startCarWash();
    }

    public static class Auton implements CarWash{

        @Override
        public void startCarWash() {
            System.out.println("완벽한 오토앤 세차");
        }
    }

    public static class InstaWash implements CarWash{

        @Override
        public void startCarWash() {
            System.out.println("완벽한 인스타워시 세차");
        }
    }

    public static class DetailingCenter {

        public void startCarWash(CarWash carWash){
            carWash.startCarWash();
        }
    }

    @Test
    void executor(){
        CarWash carWash = new InstaWash();
        DetailingCenter detailingCenter = new DetailingCenter();
        detailingCenter.startCarWash(carWash);
    }


}
