package com.example.fastforwardassignment.service;

import com.example.fastforwardassignment.domain.external.YahooFinanceRequest;
import com.example.fastforwardassignment.domain.external.YahooFinanceResponse;
import com.example.fastforwardassignment.infra.yahoo.YahooFinanceApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class YahooApiService {
    private final YahooFinanceApiClient yahooFinanceApiClient;

    public YahooFinanceResponse getYahooFinanceApiResponse(String symbol, String interval, String range) {
        final YahooFinanceRequest yahooFinanceRequest = new YahooFinanceRequest(interval, range);
        return yahooFinanceApiClient.getYahooFinance(symbol, yahooFinanceRequest);
    }
}
