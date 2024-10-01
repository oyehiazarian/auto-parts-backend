package de.auto_partshop.security.repository;


import de.auto_partshop.security.models.MyUsers;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecurityRepository extends MongoRepository<MyUsers, ObjectId> {
    Optional<MyUsers> findByName(String username);
}
