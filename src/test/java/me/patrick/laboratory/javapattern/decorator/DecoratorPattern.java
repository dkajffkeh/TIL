package me.patrick.laboratory.javapattern.decorator;

import org.junit.jupiter.api.Test;

public class DecoratorPattern {

    public interface IService{
        String runSomething();

    }

    public static class Service implements IService{

        @Override
        public String runSomething() {
            return "서비스";
        }
    }

    public static class ServiceProxy implements IService{

        Service service = new Service();

        @Override
        public String runSomething() {
            return "장식 "+service.runSomething();
        }
    }

    @Test
    void executor(){
        IService iService = new ServiceProxy();
        iService.runSomething();
    }

}
