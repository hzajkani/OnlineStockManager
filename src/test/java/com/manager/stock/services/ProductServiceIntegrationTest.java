package com.manager.stock.services;

import com.manager.stock.entities.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ProductServiceIntegrationTest {

    @Autowired
    private ProductService productService;

    @Test
    public void testAddProductHappyPath() {

        Product product = new Product();
        product.setProductId(1);
        product.setProductName(("Product Name Test"));
        product.setProductDescription(("Product Description Test"));
        product.setCapacity(80);
        Product created = productService.saveProduct(product);

        assertNotNull(created);
        assertNotNull(created.getProductId());
        assertEquals("Product Name Test", created.getProductName());
        assertTrue(created.getCapacity().equals(100));

    }
}
