package com.manager.stock;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class StockConfig {

    @Value("${stock.initial.size}")
    private String stockInitialSize;

    public String getStockInitialSize() {
        return stockInitialSize;
    }

}
