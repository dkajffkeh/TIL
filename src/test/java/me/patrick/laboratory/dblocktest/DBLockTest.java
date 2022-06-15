package me.patrick.laboratory.dblocktest;

import me.patrick.laboratory.repository.OrderMasterRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class DBLockTest {

    @Autowired
    private OrderMasterRepository orderMasterRepository;


    @Test
    @DisplayName("오더 락 테스트")
    @Transactional
    public void orderLockTest(){
        /*OrderMst orderMst = orderMasterRepository.findById(1L);*/
        /*orderMst.changeBankName("우리");*/
    }
}
