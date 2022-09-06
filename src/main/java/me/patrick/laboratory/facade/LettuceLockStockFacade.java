package me.patrick.laboratory.facade;

import me.patrick.laboratory.repository.RedisRepository;
import me.patrick.laboratory.service.StockService;
import org.springframework.stereotype.Component;

@Component
public class LettuceLockStockFacade {

    private final RedisRepository repository;

    private final StockService stockService;

    public LettuceLockStockFacade(RedisRepository repository, StockService stockService) {
        this.repository = repository;
        this.stockService = stockService;
    }

    public void decrease(Long key, Long quantity) throws InterruptedException {
        while(!repository.lock(key)) {
            Thread.sleep(100);
        }
        try {
            stockService.decrease(key,quantity);
        } finally {
            repository.unLock(key);
        }
    }
}
