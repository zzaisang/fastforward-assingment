package com.example.fastforwardassignment.infra.yahoo;

import com.example.fastforwardassignment.domain.external.YahooFinanceRequest;
import com.example.fastforwardassignment.domain.external.YahooFinanceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
        name = "yahooClient",
        url = "${external.api.url}"
)
public interface YahooFinanceApiClient {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/v8/finance/chart/{symbol}",
            consumes = "application/json"
    )
    YahooFinanceResponse getYahooFinance(
            @PathVariable("symbol") String symbol,
            @SpringQueryMap YahooFinanceRequest yahooFinanceRequest
    );
}
