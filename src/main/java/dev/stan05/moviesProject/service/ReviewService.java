package dev.stan05.moviesProject.service;

import dev.stan05.moviesProject.repository.ReviewRepository;
import dev.stan05.moviesProject.model.Movie;
import dev.stan05.moviesProject.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    /*public Review createReview(String reviewBody, String imdbId) {
        Review newReview = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(newReview))
                .first();

        return newReview;
    }*/
}
