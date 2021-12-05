package com.manager.stock.controller;

import com.manager.stock.dto.BuyStockDTO;
import com.manager.stock.dto.ProductDTO;
import com.manager.stock.entities.Product;
import com.manager.stock.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    //	2.	Ask the whole product information
    @GetMapping("/findAll")
    public List<Product> findAll() {
        return productService.getAllProduct();
    }

    @GetMapping("/geProductById/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable("productId") Integer productId) {
        return new ResponseEntity<>(productService.findProductById(productId), HttpStatus.OK);
    }

    //	3.	Ask the stock of a product
    @GetMapping("/getStockCapacity/{productId}")
    public Integer getStockCapacity(@PathVariable("productId") Integer productId) {
        return new Integer(productService.findProductById(productId).getCapacity());
    }

    //	4.	Refill the product stock
    @PutMapping("/refill")
    public ResponseEntity<Product> refillProductStock(@Valid @RequestBody ProductDTO productDTO) {
        productService.updateProduct(productDTO.toEntity());
        return new ResponseEntity<>(productDTO.toEntity(), HttpStatus.OK);
    }

    //	5.	Buying the product decreases the stock
    @PutMapping("/buy")
    public Integer buyProduct(@RequestBody BuyStockDTO buyStockDTO) {
        return productService.buyProduct(buyStockDTO.getProductId(), buyStockDTO.getCount());
    }

    @PostMapping("/saveProduct")
    public HttpStatus createProduct(@Valid @RequestBody ProductDTO productDTO) {
        productService.saveProduct(productDTO.toEntity());
        return HttpStatus.CREATED;

    }

    @DeleteMapping("/deleteProduct/{productId}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("productId") Integer productId) {
        productService.deleteProductById(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<Product> updateProduct(@Valid @RequestBody ProductDTO productDTO) {
        productService.updateProduct(productDTO.toEntity());
        return new ResponseEntity<>(productDTO.toEntity(), HttpStatus.OK);
    }

}
