package dev.stan05.moviesProject;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    // Spring will automatically understand to search movie by imdbId
    Optional<Movie> findMovieByImdbId(String imdbId);
}