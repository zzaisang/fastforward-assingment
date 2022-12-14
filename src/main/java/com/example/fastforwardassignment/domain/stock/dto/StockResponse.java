package com.example.fastforwardassignment.domain.stock.dto;

import com.example.fastforwardassignment.domain.stock.Stock;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class StockResponse {

    @ApiModelProperty(example = "2022-12-07 09:00:00", name = "거래일자")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime timestamp;

    @ApiModelProperty(example = "59600.0", name = "최고가격")
    private Double high;

    @ApiModelProperty(example = "58500.0", name = "최저가격")
    private Double low;

    @ApiModelProperty(example = "58800.0", name = "개장가격")
    private Double open;

    @ApiModelProperty(example = "58900.0", name = "종가가격")
    private Double close;

    @ApiModelProperty(example = "12100662", name = "거래량")
    private Integer volume;

    public StockResponse(Stock stock) {
        this.timestamp = stock.getStockId().getTransactionDate();
        this.high = stock.getHighPrice();
        this.low = stock.getLowPrice();
        this.open = stock.getOpenPrice();
        this.close = stock.getClosePrice();
        this.volume = stock.getVolume();
    }
}
