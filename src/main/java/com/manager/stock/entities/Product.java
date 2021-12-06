/**
 * Product Entity
 *
 * @author Hamid Zajkani
 */
package com.manager.stock.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(schema = "stock", name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String productName;
    private String productDescription;
    private Integer capacity;


    public Product() {
    }

    public Product(Integer productId, String productName, String productDescription, Integer capacity) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.capacity = capacity;
    }


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
}
