package temp.bootjsp.bootjsp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootTest
@EnableCaching // redis add
@EnableJpaAuditing // redis add
class BootjspApplicationTests {

    @Test
    void contextLoads() {
    }

}
