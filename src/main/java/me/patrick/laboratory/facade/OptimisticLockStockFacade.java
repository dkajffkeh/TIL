package me.patrick.laboratory.facade;

import me.patrick.laboratory.service.OptimisticLockStockService;
import org.springframework.stereotype.Service;

@Service
public class OptimisticLockStockFacade {

    private final OptimisticLockStockService optimisticLockStockService;

    public OptimisticLockStockFacade(OptimisticLockStockService optimisticLockStockService) {
        this.optimisticLockStockService = optimisticLockStockService;
    }

    public void decrease(Long id, Long quantity) throws InterruptedException {

        optimisticLockStockService.decrease(id, quantity);

    }
}
