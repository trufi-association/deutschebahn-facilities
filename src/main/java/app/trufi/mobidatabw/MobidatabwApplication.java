package app.trufi.mobidatabw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MobidatabwApplication {

    public static void main(String[] args) {
        SpringApplication.run(MobidatabwApplication.class, args);
    }
}
