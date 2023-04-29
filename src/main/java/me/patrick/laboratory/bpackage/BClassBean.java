package me.patrick.laboratory.bpackage;

import me.patrick.laboratory.bpackage.inb.BInnerClass;
import org.springframework.stereotype.Component;

@Component
public class BClassBean {

    private final BInnerClass bInnerClass;

    public BClassBean(BInnerClass bInnerClass) {
        this.bInnerClass = bInnerClass;
        System.out.println("Hello BClassBean");
    }

}
