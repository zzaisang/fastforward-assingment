package com.example.fastforwardassignment.service;

import com.example.fastforwardassignment.domain.stock.Stock;
import com.example.fastforwardassignment.domain.stock.dto.StockDto;
import com.example.fastforwardassignment.domain.stock.dto.StockResponse;
import com.example.fastforwardassignment.infra.yahoo.YahooFinanceApiClient;
import com.example.fastforwardassignment.properties.yahoo.DefaultParamProperties;
import com.example.fastforwardassignment.repository.StockRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class StockServiceTest {

    @InjectMocks
    private StockService stockService;

    @Mock
    private StockRepository stockRepository;

    @Mock
    private YahooApiService yahooApiService;

    @Mock
    private DefaultParamProperties defaultParamProperties;

    @Mock
    private YahooFinanceApiClient yahooFinanceApiClient;

    private StockDto stockDto;
    private long nowEpochSecond;


    @BeforeEach
    void setUp() {

        nowEpochSecond = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+9"));
        stockDto = StockDto.builder()
                .symbol("fastforward")
                .timestamp(nowEpochSecond)
                .volume(2000)
                .low(400000.0)
                .high(500000.0)
                .close(495000.0)
                .open(430000.0)
                .build();

    }


    @Test
    @Disabled
    @DisplayName("StockService 호출 unit test : service 의 기능이 두가지여서 테스트에 한계가 있어 disable 처리")
    void saveAndReturnTest() {
        final Stock stock = new Stock(stockDto);
        final StockResponse stockResponse = new StockResponse(stock);
        given(stockRepository.save(any())).willReturn(stock);

        when(stockService.getStockList()).thenReturn(List.of(stockResponse));

        Assertions.assertEquals("fastforward", stock.getStockId().getSymbol());

    }
}