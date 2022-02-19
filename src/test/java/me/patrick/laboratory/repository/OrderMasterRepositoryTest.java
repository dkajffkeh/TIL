package me.patrick.laboratory.repository;

import me.patrick.laboratory.finalvalue.dto.MemberDto;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@DisplayName("asd😁")
class OrderMasterRepositoryTest {

    @Test
    void create_test() {
        MemberDto memberDto = null;

        assertTimeout(Duration.ofSeconds(10), ()-> new MemberDto());
    }

    @Test
    void create1(){
        System.out.println();
    }

    @Test
    void assumeTest(){
        assumeTrue("LOCAL".equalsIgnoreCase(System.getenv("TEST_ENV")));
    }


    @BeforeAll
    static void beforeAll(){
        System.out.println("beforeAll");
    }

    @AfterAll
    static void AfterAll(){
        System.out.println("afterAll");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("beforeEach");
    }

    @AfterEach
    void afterEach(){
        System.out.println("afterEach");
    }

}