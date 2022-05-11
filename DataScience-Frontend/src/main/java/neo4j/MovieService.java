package neo4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Map;

@Service
public class MovieService {

    private final static Logger LOG = LoggerFactory.getLogger(MovieService.class);
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Transactional(readOnly = true)
    public Movie findByTitle(String title) {
        Movie result = (Movie) movieRepository.findMovieByTitleLike(title);
        return result;
    }

    @Transactional(readOnly = true)
    public Collection<Movie> findByTitleLike(String title) {
        Collection<Movie> result = (Collection<Movie>) movieRepository.findMovieByTitleLike(title);
        return result;
    }
/*
    @Transactional(readOnly = true)
    public Map<String, Object> graph(int limit) {
        Collection<Movie> result = movieRepository.graph(limit);
        return toD3Format(result);

        private Map<String, Object> toD3Format (Collection < Movie > movies) {
      ....
        }

        private Map<String, Object> map (String key1, Object value1, String key2, Object value2){
      ....
        }
*/
    }
