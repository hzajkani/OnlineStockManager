package com.manager.stock.services;

import com.manager.stock.entities.Product;

import java.util.List;


public interface ProductService {

    Product saveProduct(Product product);

    List<Product> getAllProduct();

    Product findProductById(Integer id);

    Product deleteProductById(Integer id);

    void updateProduct(Product product);

    Integer buyProduct(Integer productId, Integer count);

}
