package com.example.fastforwardassignment.service;

import com.example.fastforwardassignment.domain.external.YahooFinanceResponse;
import com.example.fastforwardassignment.domain.stock.Stock;
import com.example.fastforwardassignment.domain.stock.dto.StockDto;
import com.example.fastforwardassignment.domain.stock.dto.StockResponse;
import com.example.fastforwardassignment.properties.yahoo.DefaultParamProperties;
import com.example.fastforwardassignment.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {

    private final YahooApiService yahooApiService;
    private final StockRepository stockRepository;
    private final DefaultParamProperties defaultParamProperties;

    @Transactional
    public List<StockResponse> getStockList() {
        return saveStock()
                .stream()
                .map(StockResponse::new)
                .toList();
    }

    private List<Stock> saveStock() {
        final String symbol = defaultParamProperties.getSymbol();
        final YahooFinanceResponse response = yahooApiService.getYahooFinanceApiResponse(symbol, defaultParamProperties.getInterval(), defaultParamProperties.getRange());
        final List<StockDto> stockDtoList = StockDto.convert(symbol, response);
        final List<Stock> stockList = stockDtoList.stream().map(Stock::new).toList();
        return stockRepository.saveAll(stockList);
    }

}
