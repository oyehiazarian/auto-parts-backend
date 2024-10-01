package de.auto_partshop.app.repository;

import de.auto_partshop.app.models.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface DataRepository extends MongoRepository<Movie, ObjectId> {
    Optional<Movie> findDataByImdbId(String imdbId);
}
