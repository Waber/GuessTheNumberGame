package academy;

import academy.config.GameConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
@SpringBootApplication
public class Main {



    public static void main(String[] args) {
        log.info("Zgadnij numer");

        SpringApplication.run(Main.class, args);
    }

}