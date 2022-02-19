package me.patrick.laboratory.assume;

import me.patrick.laboratory.finalvalue.dto.MemberDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class AssumptionsTest {

    /**
     * assumeTest(1,2)
     * 1. 환경변수
     * 2.
     */
    @Test
    @DisplayName("환경변수별 테스트 진행 테스트")
    void assumeTest(){
        System.out.println(System.getenv("TEST_ENV"));
        assumeTrue("LOCAL".equalsIgnoreCase(System.getenv("TEST_ENV")));

        MemberDto memberDto = null;
        assertTimeout(Duration.ofSeconds(10), ()-> new MemberDto());
    }
}
