package com.manager.stock.controller;

import com.manager.stock.dto.ProductDTO;
import com.manager.stock.entities.Product;
import com.manager.stock.services.ProductService;
import com.manager.stock.util.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService service;

    @Test
    public void createProduct_whenPostMethod() throws Exception {

        Product product = new Product();
        product.setProductName("Test Name");

        given(service.saveProduct(product)).willReturn(product);

        mockMvc.perform(post("/saveProduct")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtil.toJson(product)))
                .andExpect(status().isOk());
    }

    @Test
    public void refillProduct() throws Exception {
        ProductDTO productDTO = new ProductDTO();

        productDTO.setProductName("Test Name 2");

//        given(service.saveProduct(productDTO)).willReturn(productDTO);

        mockMvc.perform(post("/refill")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtil.toJson(productDTO)))
                .andExpect(status().isOk());

    }

}
