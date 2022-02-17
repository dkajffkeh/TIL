package me.patrick.laboratory.repository;

import org.junit.jupiter.api.*;

class OrderMasterRepositoryTest {

    @Test
    void create(){
        System.out.println("create1");
    }

    @Test
    void create1(){
        System.out.println("create2");
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