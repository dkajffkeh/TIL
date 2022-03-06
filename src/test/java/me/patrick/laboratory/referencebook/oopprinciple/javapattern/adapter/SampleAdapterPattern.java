package me.patrick.laboratory.referencebook.oopprinciple.javapattern.adapter;

import org.junit.jupiter.api.Test;

public class SampleAdapterPattern {

    public interface Auton{
        void detailing();
        void visit();
    }

    public static class AutonImpl implements Auton{

        @Override
        public void detailing() {
            System.out.println("내부 세차로직");
        }

        @Override
        public void visit() {
            System.out.println("기사 방문");
        }
    }

    public interface InstaWash{
        void carWash();
        void delivery();
    }

    public static class InstaWashImpl implements InstaWash{

        private final Auton auton;

        public InstaWashImpl(Auton auton) {
            this.auton = auton;
        }

        @Override
        public void carWash() {
            System.out.println("차량 외부 세차로직");
            auton.detailing();
        }

        @Override
        public void delivery() {
            System.out.println("차량 배달 로직");
        }
    }

    @Test
    void executor(){
        InstaWash instaWash = new InstaWashImpl(new AutonImpl());
        instaWash.carWash();
        instaWash.delivery();
    }
}
