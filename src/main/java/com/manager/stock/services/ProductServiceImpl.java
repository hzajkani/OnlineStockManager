package com.manager.stock.services;

import com.manager.stock.util.StockConfig;
import com.manager.stock.entities.Product;
import com.manager.stock.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository ptoductRespository;

    @Autowired
    StockConfig stockConfig;

    public Product saveProduct(Product product) {
        if (stockConfig != null) {
            product.setCapacity(Integer.parseInt((stockConfig.getStockInitialSize())));
        }
        return ptoductRespository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return ptoductRespository.findAll();
    }


    @Override
    public Product findProductById(Integer id) {
        return ptoductRespository.findProductByProductId(id);
    }

    public Product deleteProductById(Integer id) {
        ptoductRespository.deleteById(id.toString());
        return null;
    }

    @Override
    public void updateProduct(Product product) {
        ptoductRespository.save(product);
    }

    @Override
    public Integer buyProduct(Integer productId, Integer count) {
        Integer currentCapacity = ptoductRespository.findProductByProductId(productId).getCapacity();
        if (currentCapacity >= count) {
            Product product = ptoductRespository.findProductByProductId(productId);
            product.setCapacity(currentCapacity - count);
            ptoductRespository.save(product);
        } else {
            //todo prompt "capacity its not enough"
        }

        return ptoductRespository.findProductByProductId(productId).getCapacity();
    }
}
