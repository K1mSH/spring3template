package temp.bootjsp.bootjsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("boot.mytemp.*")
public class BootjspApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootjspApplication.class, args);
    }

}
