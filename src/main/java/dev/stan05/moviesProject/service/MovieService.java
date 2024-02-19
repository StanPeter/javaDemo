package dev.stan05.moviesProject.service;

import dev.stan05.moviesProject.model.Movie;
import dev.stan05.moviesProject.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponse;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired // init this field automatically
    private MovieRepository movieRepository;

    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> singleMovie(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }

    public Movie saveMovie(Movie newMovieBody) {
        if (newMovieBody.getImdbId() == null) {
            return null;
        }

        Movie newMovie = movieRepository.save(newMovieBody);
        return newMovie;
    }

    public Movie updateMovie(String imdbId, Movie body) {
        Optional<Movie> updatedMovie = this.singleMovie(imdbId);

        if (!updatedMovie.isEmpty()) {
            Movie existingMovie = updatedMovie.get();

            // for now supports only changing the title
            existingMovie.setTitle(body.getTitle() != null ? body.getTitle() : existingMovie.getTitle());

            return movieRepository.save(existingMovie);
        }

        return null;
    }

    public Boolean deleteMovie(String imdbId) {
        Optional<Movie> foundMovie = this.singleMovie(imdbId);

        if (foundMovie.isPresent()) {
            movieRepository.deleteMovieByImdbId(imdbId);
            return true;
        } else {
            return false;
        }
    }
}
