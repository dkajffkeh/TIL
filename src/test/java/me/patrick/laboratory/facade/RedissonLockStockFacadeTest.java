package me.patrick.laboratory.facade;

import me.patrick.laboratory.finalvalue.entity.Stock;
import me.patrick.laboratory.repository.StockRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RedissonLockStockFacadeTest {


    @Autowired
    private RedissonLockStockFacade stockService;

    @Autowired
    private StockRepository stockRepository;

    @BeforeEach
    public void before() {
        Stock stock = new Stock(1L, 100L);

        stockRepository.save(stock);
    }

    @AfterEach
    public void afterEach() {
        stockRepository.deleteAll();
    }


    @Test
    public void 동시에_100명이_주문() throws InterruptedException {
        int threadCount = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            executorService.submit(() -> {
                try {
                    stockService.decrease(1L, 1L);
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();

        Stock stock = stockRepository.findById(1L).get();

        // 100 - (100 * 1) = 0
        assertEquals(0, stock.getQuantity());
    }
}