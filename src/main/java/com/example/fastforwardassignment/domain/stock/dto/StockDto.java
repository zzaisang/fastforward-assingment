package com.example.fastforwardassignment.domain.stock.dto;

import com.example.fastforwardassignment.domain.Code;
import com.example.fastforwardassignment.domain.external.YahooFinanceResponse;
import com.example.fastforwardassignment.exception.ApiException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockDto {

    private String symbol;

    private Long timestamp;

    private Double open;

    private Integer volume;

    private Double close;

    private Double high;

    private Double low;

    public static List<StockDto> convert(String symbol, YahooFinanceResponse response) {
        final List<YahooFinanceResponse.Result> resultList = response.getChart().getResult();

        return resultList.stream()
                .map(result -> {
                    final List<Long> resultTimestamp = result.getTimestamp();
                    final YahooFinanceResponse.Indicators resultIndicators = result.getIndicators();
                    final YahooFinanceResponse.Quote quote = resultIndicators.getQuote().stream().findFirst().orElseThrow(() -> new ApiException(Code.NO_DATA));
                    List<StockDto> stockDtoList = new ArrayList<>();
                    for (int i = 0; i < resultTimestamp.size(); i++) {
                        final StockDto stockDto = StockDto.builder()
                                .symbol(symbol)
                                .timestamp(result.getTimestamp().get(i))
                                .open(quote.getOpen().get(i))
                                .volume(quote.getVolume().get(i))
                                .close(quote.getClose().get(i))
                                .high(quote.getHigh().get(i))
                                .low(quote.getLow().get(i))
                                .build();
                        stockDtoList.add(stockDto);
                    }
                    return stockDtoList;
                }).flatMap(Collection::stream)
                .toList();
    }

}
