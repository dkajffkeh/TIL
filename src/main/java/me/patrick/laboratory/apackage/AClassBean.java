package me.patrick.laboratory.apackage;

import me.patrick.laboratory.apackage.ina.AInnerClass;
import org.springframework.stereotype.Component;

@Component
public class AClassBean {

    private final AInnerClass aInnerClass;

    public AClassBean(AInnerClass aInnerClass) {
        System.out.println("Hello AClassBean");
        this.aInnerClass = aInnerClass;
    }
}
