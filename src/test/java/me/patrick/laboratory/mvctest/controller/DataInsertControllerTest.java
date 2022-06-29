package me.patrick.laboratory.mvctest.controller;

import me.patrick.laboratory.repository.MemberQueryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class DataInsertControllerTest {

    @Autowired
    private DataInsertController dataInsertController;

    @Autowired
    private MemberQueryRepository memberQueryRepository;

    @Test
    void test() {

    }

    @Test
    @Transactional
    void nPlusOneTest(){

    }
}