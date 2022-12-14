package com.example.fastforwardassignment.repository;

import com.example.fastforwardassignment.domain.stock.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {

}
