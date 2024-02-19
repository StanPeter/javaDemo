package dev.stan05.moviesProject.service;

import dev.stan05.moviesProject.model.Movie;
import dev.stan05.moviesProject.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired // init this field automatically
    private MovieRepository movieRepository;
    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }
    public Optional<Movie> singleMovie(String id) {
        return movieRepository.findMovieByImdbId(id);
    }
}