package me.patrick.laboratory.memoryleak;

import me.patrick.laboratory.memoryleak.EnclosingClass.EnclosedClass;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MemoryLeak {

    @Test
    void leak(){
        ArrayList<EnclosedClass> al = new ArrayList<>();
        int counter = 0;
        while (true)
        {
            al.add(new EnclosingClass(100000).getEnclosedClassObject());
            System.out.println(counter++);
        }
    }
}
