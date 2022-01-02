package me.patrick.laboratory.support;

import me.patrick.laboratory.thread.ThreadSafeObject;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractBean {

    @Autowired
    private ThreadSafeObject threadSafeObject;

    public ThreadSafeObject test(){
        return threadSafeObject;
    }
}
