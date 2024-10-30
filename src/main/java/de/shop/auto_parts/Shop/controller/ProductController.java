package de.shop.auto_parts.Shop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.shop.auto_parts.Shop.model.Product;
import de.shop.auto_parts.Shop.service.ProductService;
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{article}")
    public ResponseEntity<Optional<Product>> getSingleProduct(@PathVariable String article) {
        return new ResponseEntity<Optional<Product>>(productService.singleProduct(article), HttpStatus.OK);
    }
}
