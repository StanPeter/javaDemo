package dev.stan05.moviesProject;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private  MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getMovie(@PathVariable String id) {
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(id), HttpStatus.OK);
    }
    /*@PostMapping
    public ResponseEntity<Boolean> addMovie(Movie newMovie) {
        movieService.
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<Boolean> removeMovie(String id) {
        return
    }*/
}
