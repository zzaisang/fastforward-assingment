package com.example.fastforwardassignment.domain.external;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class YahooFinanceRequest {

    private String interval;

    private String range;

}
