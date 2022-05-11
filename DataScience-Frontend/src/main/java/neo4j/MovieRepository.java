package neo4j;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import java.util.Collection;

public interface MovieRepository extends Neo4jRepository<Movie, Long> {

    Movie getMovieByTitle(String title);

    Iterable<Movie> findMovieByTitleLike(String title);
}
