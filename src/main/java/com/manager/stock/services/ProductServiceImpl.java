package com.manager.stock.services;

import com.manager.stock.entities.Product;
import com.manager.stock.repositories.ProductRepository;
import com.manager.stock.util.StockConfig;
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
    public Product updateProduct(Integer productId, Product newProduct) {
        Product previousProduct = ptoductRespository.findProductByProductId(productId);
        previousProduct.setProductName(newProduct.getProductName());
        previousProduct.setCapacity(newProduct.getCapacity());
        previousProduct.setProductDescription(newProduct.getProductDescription());
        return ptoductRespository.save(previousProduct);
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
