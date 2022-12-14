package com.example.fastforwardassignment.domain.stock;

import com.example.fastforwardassignment.domain.stock.dto.StockDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Getter
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Stock {

    @EmbeddedId
    private StockId stockId;

    private Double highPrice;

    private Double lowPrice;

    private Double openPrice;

    private Double closePrice;

    private Integer volume;

    public Stock(StockDto stockDto) {
        this.stockId = new StockId(stockDto.getSymbol(), stockDto.getTimestamp());
        this.highPrice = stockDto.getHigh();
        this.lowPrice = stockDto.getLow();
        this.openPrice = stockDto.getOpen();
        this.closePrice = stockDto.getClose();
        this.volume = stockDto.getVolume();
    }
}
