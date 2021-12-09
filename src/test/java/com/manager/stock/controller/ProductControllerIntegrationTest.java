package com.manager.stock.controller;

import com.manager.stock.dto.ProductDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerIntegrationTest {

    @Autowired
    private ProductController productController;

    @Test
    public void testAddProductHappyPath() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(1);
        productDTO.setProductName(("Product Name Test"));
        productDTO.setProductDescription(("Product Description Test"));
        productDTO.setCapacity(80);

        HttpStatus httpStatus = productController.createProduct(productDTO);
        assertThat(httpStatus, is(equalTo(HttpStatus.CREATED)));


    }

}
