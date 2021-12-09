package com.manager.stock.controller;

import com.manager.stock.dto.ProductDTO;
import com.manager.stock.entities.Product;
import com.manager.stock.services.ProductServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductServiceImpl productService;

    @InjectMocks
    private ProductController productController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddProductHappyPath() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(1);
        productDTO.setProductName(("Product Name Test"));
        productDTO.setProductDescription(("Product Description Test"));
        productDTO.setCapacity(80);

        Product product = productDTO.toEntity();
        when(productService.saveProduct(any(Product.class))).thenReturn(product);

        ProductDTO aProductDTO = new ProductDTO();
        aProductDTO.setProductId(10);
        aProductDTO.setProductName(("Product Name Test"));
        aProductDTO.setProductDescription(("Product Description Test"));
        aProductDTO.setCapacity(80);

        mockMvc.perform(post("/saveProduct",aProductDTO))
                .andExpect(status().isOk()).andReturn();

    }


}
