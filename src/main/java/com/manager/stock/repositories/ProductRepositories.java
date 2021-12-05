package com.manager.stock.repositories;

import com.manager.stock.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepositories extends JpaRepository<Product, String> {
    Product findProductByProductId(Integer id);
}
