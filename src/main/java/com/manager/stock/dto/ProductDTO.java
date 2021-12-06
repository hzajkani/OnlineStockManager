/**
 * This DTO is for ProductDTO to prevent Domain Entity represent straightly to clients
 *
 * @author Hamid Zajkani
 */
package com.manager.stock.dto;

import com.manager.stock.entities.Product;

public class ProductDTO {
    private Integer productId;
    private String productName;
    private String productDescription;
    private Integer capacity;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Product toEntity() {
        Product product = new Product();

        product.setProductId(productId);
        product.setProductName(productName);
        product.setProductDescription(productDescription);
        product.setCapacity(capacity);
        return product;
    }

}
