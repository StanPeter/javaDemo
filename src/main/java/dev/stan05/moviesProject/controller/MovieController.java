package dev.stan05.moviesProject.controller;

import dev.stan05.moviesProject.model.Movie;
import dev.stan05.moviesProject.service.MovieService;
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
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getMovie(@PathVariable String id) {
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(Movie newMovie) {
        /*System.out.println(newMovie.toString());

        if (newMovie.getImdbId() == null) {
            System.out.println("Missing parameter of ID");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        };*/

        return new ResponseEntity<Movie>(movieService.saveMovie(newMovie), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> editMovie(@PathVariable String id, @RequestBody Movie editedMovie) {
        System.out.println(id + " IMBDP IDESASAASSA");
        return new ResponseEntity<Movie>(movieService.updateMovie(id, editedMovie), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> removeMovie(@PathVariable String id) {
        return new ResponseEntity<Boolean>(movieService.deleteMovie(id), HttpStatus.OK);
    }
}
