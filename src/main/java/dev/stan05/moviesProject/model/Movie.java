package dev.stan05.moviesProject.model;


import dev.stan05.moviesProject.model.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.http.HttpStatusCode;

import java.util.List;

@Document(collection = "movies")
@Data // adds getters and setters to all properties
@AllArgsConstructor // creates auto constructor to add all properties
@NoArgsConstructor
public class Movie {

    @Id
    private ObjectId id;

    private String imdbId;

    @NonNull
    private String title;

    private String releaseDate;

    private String trailerLink;

    private String poster;

    private List<String> genres;

    private List<String> backdrops;

    @DocumentReference
    private List<Review> reviewIds;
}
