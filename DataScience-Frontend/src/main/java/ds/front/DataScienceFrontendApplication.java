package ds.front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableCaching
@EnableNeo4jRepositories("ds.front.Neo4J.repository")
public class DataScienceFrontendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataScienceFrontendApplication.class, args);
    }
}
