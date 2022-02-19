package me.patrick.laboratory.tagnfilter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TaggingAndFiltering {

    @Test
    @DisplayName("테깅과 필터링")
    @Tag("fast")
    void fasterTest(){
        System.out.println("fast");
    }

    @Test
    @DisplayName("테깅과 필터링")
    @Tag("slow")
    void slowerTest(){
        System.out.println("slow");
    }
}
