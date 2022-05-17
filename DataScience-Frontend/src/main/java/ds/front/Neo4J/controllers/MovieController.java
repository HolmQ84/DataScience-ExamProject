package ds.front.Neo4J.controllers;

import ds.front.Neo4J.model.*;
import ds.front.Neo4J.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private static MovieRepository movieRepository;

    public MovieController() {
    }

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public Iterable<Movie> findAll() {
        return movieRepository.findAll();
    }

    @GetMapping("/{title}")
    public Movie getMovieByTitle(@PathVariable String title) {
        return movieRepository.getMovieByTitle(title);
    }

    @GetMapping("/search/{title}")
    public Iterable<Movie> findMovieByTitleLike(@PathVariable String title) {
        return movieRepository.findMovieByTitleLike(title);
    }

    @GetMapping("/graph")
    public Collection<Movie> graph(@RequestParam(value = "limit", required = false) Integer limit) {
        Collection<Movie> result = movieRepository.graph(limit == null ? 100 : limit);
        return result;
    }
}
