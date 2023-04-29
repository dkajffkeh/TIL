package me.patrick.laboratory.apackage.ina;

import me.patrick.laboratory.bpackage.inb.SecondBeanClass;
import org.springframework.stereotype.Component;

@Component
public class FirstBeanClass {
    private final SecondBeanClass secondBeanClass;

    public FirstBeanClass(SecondBeanClass secondBeanClass) {
        this.secondBeanClass = secondBeanClass;
        System.out.println("Hello FirstBeanClass");
    }

}
