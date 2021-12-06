/**
 * This Class Represent Rest API for Product
 *
 * @author Hamid Zajkani
 */

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

    /**
     * This is a method that fetches all Product entities in a List.
     *
     * @return List<Product>
     */
    @GetMapping("/findAll")
    public List<Product> findAll() {
        return productService.getAllProduct();
    }

    /**
     * This is a method that get one Product details by ProductId.
     *
     * @param productId
     * @return ResponseEntity<Product>
     */
    @GetMapping("/geProductById/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable("productId") Integer productId) {
        return new ResponseEntity<>(productService.findProductById(productId), HttpStatus.OK);
    }

    /**
     * This is a method for get a Stock Capacity on a specific Product by ProductId.
     *
     * @param productId
     * @return Integer stockCapacity
     */
    @GetMapping("/getStockCapacity/{productId}")
    public Integer getStockCapacity(@PathVariable("productId") Integer productId) {
        return new Integer(productService.findProductById(productId).getCapacity());
    }

    /**
     * This is a method for refill a Product.
     *
     * @param productDTO
     * @return ResponseEntity<Product>
     */
    @PutMapping("/refill")
    public ResponseEntity<Product> refillProductStock(@Valid @RequestBody ProductDTO productDTO) {
        productService.updateProduct(productDTO.getProductId(), productDTO.toEntity());
        return new ResponseEntity<>(productDTO.toEntity(), HttpStatus.OK);
    }


    /**
     * Buying the product decreases the stock.
     *
     * @param buyStockDTO
     * @return Integer result Capacity
     */
    @PutMapping("/buy")
    public Integer buyProduct(@RequestBody BuyStockDTO buyStockDTO) {
        return productService.buyProduct(buyStockDTO.getProductId(), buyStockDTO.getCount());
    }

    /**
     * a Post method for creates Product
     *
     * @param productDTO
     * @return HttpStatus
     */
    @PostMapping("/saveProduct")
    public HttpStatus createProduct(@Valid @RequestBody ProductDTO productDTO) {
        productService.saveProduct(productDTO.toEntity());
        return HttpStatus.CREATED;

    }

    /**
     * a  method for Delete a Product
     *
     * @param productId
     * @return ResponseEntity<Product>
     */
    @DeleteMapping("/deleteProduct/{productId}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("productId") Integer productId) {
        productService.deleteProductById(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * a  method for Update a Product
     *
     * @param productDTO
     * @return ResponseEntity<Product>
     */
    @PutMapping("/updateProduct")
    public ResponseEntity<Product> updateProduct(@Valid @RequestBody ProductDTO productDTO) {
        productService.updateProduct(productDTO.getProductId(), productDTO.toEntity());
        return new ResponseEntity<>(productDTO.toEntity(), HttpStatus.OK);
    }

}
