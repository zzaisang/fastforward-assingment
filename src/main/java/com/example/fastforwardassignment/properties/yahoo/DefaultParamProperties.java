package com.example.fastforwardassignment.properties.yahoo;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Getter
@Configuration
public class DefaultParamProperties {

    @Value("${external.api.default[0].symbol}")
    private String symbol;

    @Value("${external.api.default[1].interval}")
    private String interval;

    @Value("${external.api.default[2].range}")
    private String range;

}
