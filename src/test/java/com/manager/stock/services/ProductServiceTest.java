package com.manager.stock.services;

import com.manager.stock.entities.Product;
import com.manager.stock.repositories.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    public void whenSaveProduct_shouldReturnProduct() {
        Product product = new Product();
        product.setProductName(("Product Name"));
        product.setProductDescription(("Product Description"));

        when(productRepository.save(ArgumentMatchers.any(Product.class))).thenReturn(product);

        Product created = productService.saveProduct(product);

        assertThat(created.getProductName()).isSameAs(product.getProductName());
        verify(productRepository).save(product);
    }
}
