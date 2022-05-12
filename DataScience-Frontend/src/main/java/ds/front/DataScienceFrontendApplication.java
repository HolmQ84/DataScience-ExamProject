package ds.front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DataScienceFrontendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataScienceFrontendApplication.class, args);
    }

}
