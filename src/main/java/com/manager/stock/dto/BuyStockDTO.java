/**
 * This DTO is for Buying Stock
 *
 * @author Hamid Zajkani
 */

package com.manager.stock.dto;

public class BuyStockDTO {
    private Integer productId;
    private Integer count;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
