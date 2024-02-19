package dev.stan05.moviesProject.repository;

import dev.stan05.moviesProject.model.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<Movie, ObjectId> {
}