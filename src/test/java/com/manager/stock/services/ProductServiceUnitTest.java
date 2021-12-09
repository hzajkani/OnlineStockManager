package com.manager.stock.services;

import com.manager.stock.entities.Product;
import com.manager.stock.repositories.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ProductServiceUnitTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddProductHappyPath() {


        Product product = new Product();
        product.setProductId(1);
        product.setProductName(("Product Name Test"));
        product.setProductDescription(("Product Description Test"));
        product.setCapacity(80);

        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product newProduct = productService.saveProduct(product);

        assertEquals("Product Name Test", newProduct.getProductName());
    }

}
