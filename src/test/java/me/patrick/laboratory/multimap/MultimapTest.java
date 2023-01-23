package me.patrick.laboratory.multimap;

import com.ctc.wstx.shaded.msv_core.grammar.OtherExp;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.junit.jupiter.api.Test;

import java.util.*;

public class MultimapTest {

    @Test
    void multiMapTest() {

        OuterClass outerClass1 = new OuterClass();
        OuterClass outerClass2 = new OuterClass();
        OuterClass outerClass3 = new OuterClass();

        List<OuterClass> outerClasses = Arrays.asList(outerClass1,outerClass2,outerClass3);
        outerClasses.stream()
                .map(OuterClass::getClasses)
                .flatMap(Collection::stream)
                .forEach(innerClass -> System.out.println(innerClass.getB()));
        ;
        ;

    }

    public static class OuterClass {

        List<InnerClass> classes = new ArrayList<>();

        public List<InnerClass> getClasses() {
            return classes;
        }

        public void setClasses(List<InnerClass> classes) {
            this.classes = classes;
        }
    }

    public static class InnerClass {

        private String b;

        public String getB() {
            return b;
        }
    }
}
