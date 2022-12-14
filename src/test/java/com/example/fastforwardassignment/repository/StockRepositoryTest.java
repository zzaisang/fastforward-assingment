package com.example.fastforwardassignment.repository;

import com.example.fastforwardassignment.domain.stock.Stock;
import com.example.fastforwardassignment.domain.stock.StockId;
import com.example.fastforwardassignment.domain.stock.dto.StockDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StockRepositoryTest extends RepositoryTest {

    @Autowired
    private StockRepository stockRepository;

    private StockDto stockDto;
    private long nowEpochSecond;

    @BeforeEach
    void setup() {

        nowEpochSecond = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+9"));

        stockDto = StockDto.builder()
                .symbol("fastforward")
                .timestamp(nowEpochSecond)
                .volume(1000)
                .low(100000.0)
                .high(200000.0)
                .close(195000.0)
                .open(130000.0)
                .build();
    }

    @Nested
    @DisplayName("주식 데이터 Insert Test")
    class SaveStock {

        @Test
        @DisplayName("주식 데이터 정상 insert Test")
        void saveStock() {
            final Stock saveStock = stockRepository.save(new Stock(stockDto));

            assertEquals(1, stockRepository.count());
            assertEquals("fastforward", saveStock.getStockId().getSymbol());
            assertEquals(1000, saveStock.getVolume());
        }

        @Test
        @DisplayName("주식 데이터 insert Test : 중복 pk")
        void saveStock_duplicate_pk() {
            stockRepository.saveAndFlush(new Stock(stockDto));

            final StockDto newStockDto = StockDto.builder()
                    .symbol("fastforward")
                    .timestamp(nowEpochSecond)
                    .volume(2000)
                    .low(400000.0)
                    .high(500000.0)
                    .close(495000.0)
                    .open(430000.0)
                    .build();
            final Stock saveStock2 = stockRepository.save(new Stock(newStockDto));

            assertEquals(1, stockRepository.count());
            assertEquals(new StockId("fastforward", nowEpochSecond), stockRepository.findAll().stream().findFirst().map(Stock::getStockId).orElse(null));
            assertEquals(2000, saveStock2.getVolume());
        }
    }
}