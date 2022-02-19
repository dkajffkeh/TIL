package me.patrick.laboratory.assume;

import me.patrick.laboratory.finalvalue.dto.MemberDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class AssumptionsTest {

    /**
     * assumeTest(1,2)
     * 1. 환경변수
     * 2.
     */
    @Test
    @DisplayName("환경변수별 테스트 진행 테스트")
    void assumeTest(){
        // 환경변수중 TEST_ENV 가 LOCAL 일 경우 아래 테스트를 진행함.
        System.out.println(System.getenv("TEST_ENV"));
        assumeTrue("LOCAL".equalsIgnoreCase(System.getenv("TEST_ENV")));

        MemberDto memberDto = null;
        assertTimeout(Duration.ofSeconds(10), ()-> new MemberDto());
    }

    @Test
    @DisplayName("환경변수별 테스트 진행 응용")
    void assumeApplyTest(){

        String env = System.getenv("TEST_ENV");

        assumingThat("LOCAL".equalsIgnoreCase(env),
                () -> {
                assertThat("a".equals("a"));
                });

        assumingThat("DEV".equalsIgnoreCase(env),
                () -> {
                    assertThat("a".equals("a"));
                });
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void enabledOnOsTest(){
        System.out.println("test Mac");
    }


    @Test
    @EnabledOnOs({OS.LINUX, OS.WINDOWS})
    void enabledOnOsTestLinux(){
        System.out.println("test Linux");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void testByJREVersion(){
        System.out.println("test");
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "LOCAL")
    void environmentTest(){
        System.out.println("test");
    }

}
