package me.patrick.laboratory.javapattern.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.util.ObjectUtils;

public class SingletonPattern {

    public static class Singleton{

        private static Singleton singleton;
        private Singleton(){

        }

        public static Singleton getInstance(){
            if (ObjectUtils.isEmpty(singleton)){
                singleton = new Singleton();
            }
            return singleton;
        }
    }

    @Test
    void singletonTest(){
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        Singleton s3 = Singleton.getInstance();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

    }
}
