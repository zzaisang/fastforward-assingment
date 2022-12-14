package com.example.fastforwardassignment.domain.external;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


@Data
public class YahooFinanceResponse {

    @JsonProperty("chart")
    private Chart chart;

    @Data
    public static class Chart {
        @JsonProperty("result")
        private List<Result> result;
    }

    @Data
    public static class Result {
        @JsonProperty("indicators")
        private Indicators indicators;
        @JsonProperty("timestamp")
        private List<Long> timestamp;
        @JsonProperty("meta")
        private Meta meta;
    }

    @Data
    public static class Indicators {
        @JsonProperty("adjclose")
        private List<Adjclose> adjclose;
        @JsonProperty("quote")
        private List<Quote> quote;
    }

    @Data
    public static class Adjclose {
        @JsonProperty("adjclose")
        private List<Integer> adjclose;
    }

    @Data
    public static class Quote {
        @JsonProperty("open")
        private List<Double> open;
        @JsonProperty("volume")
        private List<Integer> volume;
        @JsonProperty("close")
        private List<Double> close;
        @JsonProperty("high")
        private List<Double> high;
        @JsonProperty("low")
        private List<Double> low;
    }

    @Data
    public static class Meta {
        @JsonProperty("validRanges")
        private List<String> validRanges;
        @JsonProperty("range")
        private String range;
        @JsonProperty("dataGranularity")
        private String dataGranularity;
        @JsonProperty("currentTradingPeriod")
        private CurrentTradingPeriod currentTradingPeriod;
        @JsonProperty("priceHint")
        private int priceHint;
        @JsonProperty("chartPreviousClose")
        private int chartPreviousClose;
        @JsonProperty("regularMarketPrice")
        private int regularMarketPrice;
        @JsonProperty("exchangeTimezoneName")
        private String exchangeTimezoneName;
        @JsonProperty("timezone")
        private String timezone;
        @JsonProperty("gmtoffset")
        private int gmtoffset;
        @JsonProperty("regularMarketTime")
        private int regularMarketTime;
        @JsonProperty("firstTradeDate")
        private int firstTradeDate;
        @JsonProperty("instrumentType")
        private String instrumentType;
        @JsonProperty("exchangeName")
        private String exchangeName;
        @JsonProperty("symbol")
        private String symbol;
        @JsonProperty("currency")
        private String currency;
    }

    @Data
    public static class CurrentTradingPeriod {
        @JsonProperty("post")
        private Post post;
        @JsonProperty("regular")
        private Regular regular;
        @JsonProperty("pre")
        private Pre pre;
    }

    @Data
    public static class Post {
        @JsonProperty("gmtoffset")
        private int gmtoffset;
        @JsonProperty("end")
        private int end;
        @JsonProperty("start")
        private int start;
        @JsonProperty("timezone")
        private String timezone;
    }

    @Data
    public static class Regular {
        @JsonProperty("gmtoffset")
        private int gmtoffset;
        @JsonProperty("end")
        private int end;
        @JsonProperty("start")
        private int start;
        @JsonProperty("timezone")
        private String timezone;
    }

    @Data
    public static class Pre {
        @JsonProperty("gmtoffset")
        private int gmtoffset;
        @JsonProperty("end")
        private int end;
        @JsonProperty("start")
        private int start;
        @JsonProperty("timezone")
        private String timezone;
    }
}
