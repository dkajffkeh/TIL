package me.patrick.laboratory.service;

import lombok.AllArgsConstructor;
import me.patrick.laboratory.finalvalue.entity.Stock;
import me.patrick.laboratory.repository.StockRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    public void decrease(Long id, Long quantity) {

        Stock stock = stockRepository.findById(id).orElseThrow(RuntimeException::new);

        stock.decrease(quantity);

        stockRepository.saveAndFlush(stock);

    }
}
