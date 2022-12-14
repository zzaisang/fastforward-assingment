package com.example.fastforwardassignment.infra.yahoo;

import com.example.fastforwardassignment.domain.external.YahooFinanceRequest;
import com.example.fastforwardassignment.domain.external.YahooFinanceResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class YahooFinanceApiClientTest {

    @Autowired
    private YahooFinanceApiClient yahooFinanceApiClient;

    @Test
    @DisplayName("Yahoo Finance API Call Test")
    void testYahooApiCall() {

        final YahooFinanceResponse response = yahooFinanceApiClient.getYahooFinance("005930.KS", new YahooFinanceRequest("1d", "1d"));

        assertEquals(1, response.getChart().getResult().size());
        assertEquals(1, response.getChart().getResult().get(0).getTimestamp().size());
    }
}