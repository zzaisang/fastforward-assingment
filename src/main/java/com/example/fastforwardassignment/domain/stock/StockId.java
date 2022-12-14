package com.example.fastforwardassignment.domain.stock;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Objects;

import static java.time.LocalDateTime.ofEpochSecond;

@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StockId implements Serializable {

    private String symbol;

    private LocalDateTime transactionDate;

    public StockId(String symbol, Long timestamp) {
        this.symbol = symbol;
        this.transactionDate = ofEpochSecond(timestamp, 0, ZoneOffset.of("+9"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockId stockId = (StockId) o;
        return Objects.equals(symbol, stockId.symbol) && Objects.equals(transactionDate, stockId.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, transactionDate);
    }
}
