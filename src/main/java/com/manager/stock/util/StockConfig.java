/**
 * This Class is for reading properties in Application that we don't want to Hard Coded in program.
 *
 * @author Hamid Zajkani
 */
package com.manager.stock.util;

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
