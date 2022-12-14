package com.example.fastforwardassignment.controller;

import com.example.fastforwardassignment.domain.stock.dto.StockResponse;
import com.example.fastforwardassignment.service.StockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "주식 Controller")
@RestController
@RequiredArgsConstructor
@RequestMapping("/stock")
public class StockController {

    private final StockService stockService;

    @ApiOperation(value = "삼성전자 주식 5일치 데이터 출력 API")
    @PostMapping
    public ResponseEntity<List<StockResponse>> getStock() {
        return ResponseEntity.ok(this.stockService.getStockList());
    }
}
