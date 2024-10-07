package de.shop.auto_parts.Shop.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import de.shop.auto_parts.Shop.model.Product;
import lombok.Data;

@Repository
public interface ProductRepository extends MongoRepository<Product, ObjectId> {
    Optional<Product> findByArticle(String article);
}
