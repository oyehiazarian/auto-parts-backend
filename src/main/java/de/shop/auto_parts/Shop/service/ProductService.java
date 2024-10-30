package de.shop.auto_parts.Shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.shop.auto_parts.Shop.model.Product;
import de.shop.auto_parts.Shop.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> singleProduct(String article){
        return productRepository.findByArticle(article);
    }

}
