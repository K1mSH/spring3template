package temp.bootjsp.bootjsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@ComponentScan("boot.mytemp.*")
@EnableRedisRepositories
@EnableJpaRepositories // jpa에서 @repository scan 가능토록 함
public class BootjspApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootjspApplication.class, args);
    }

}
