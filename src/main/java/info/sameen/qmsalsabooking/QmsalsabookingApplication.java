package info.sameen.qmsalsabooking;

import info.sameen.qmsalsabooking.config.SecurityConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({SecurityConfiguration.class})
public class QmsalsabookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(QmsalsabookingApplication.class, args);
    }
}
