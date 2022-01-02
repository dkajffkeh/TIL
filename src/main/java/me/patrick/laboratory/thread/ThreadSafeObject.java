package me.patrick.laboratory.thread;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ThreadSafeObject {

    public void test(){
        System.out.println("??");
    }
}
