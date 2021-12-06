package com.manager.stock.services;

import com.manager.stock.entities.Product;

import java.util.List;


public interface ProductService {

    Product saveProduct(Product product);

    List<Product> getAllProduct();

    Product findProductById(Integer productId);

    Product deleteProductById(Integer productId);

    Product updateProduct(Integer productId , Product newProduct);

    Integer buyProduct(Integer productId, Integer count);

}
