package neo4j;

import org.springframework.web.bind.annotation.*;

// https://www.codementor.io/@asadali555/introduction-to-spring-data-neo4j-17brd2jfvd
// https://itsilesia.com/neo4j-with-spring-boot/
// https://medium.com/neo4j/spring-into-neo4j-with-spring-data-5-spring-boot-2-and-neo4j-3962fb1ea067


@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieRepository movieRepository;

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
}
