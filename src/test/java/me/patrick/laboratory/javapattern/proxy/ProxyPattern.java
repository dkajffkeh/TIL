package me.patrick.laboratory.javapattern.proxy;

import org.junit.jupiter.api.Test;

public class ProxyPattern {

    public interface JpaRepository{
        void save(Object object);
    }

    public static class MemberHandler implements JpaRepository{

        @Override
        public void save(Object object) {
            System.out.println("Parameter object 를 디비에 저장하는 로직");
        }
    }

    public static class MemberHandlerProxy implements JpaRepository{

        MemberHandler memberHandler = new MemberHandler();

        @Override
        public void save(Object object) {
            System.out.println("JDBC 커넥션 연결로직");
            try{
              memberHandler.save(object);
            } catch (Exception e){
                System.out.println("save 된 데이터 롤백 로직");
            }
            System.out.println("JDBC 커넥션 종료");
        }
    }

    @Test
    void executor(){
        JpaRepository jpaRepository = new MemberHandlerProxy();
        jpaRepository.save("some Object");
    }
}
