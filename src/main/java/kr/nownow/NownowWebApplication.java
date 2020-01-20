package kr.nownow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class NownowWebApplication {

    public static final String CONFIG_LOCATION = "spring.config.location=" +
            "classpath:application.yml" +
            "/home/nownow-web/config/real-application.yml";

    public static void main(String[] args) {
        new SpringApplicationBuilder(NownowWebApplication.class)
                .properties(CONFIG_LOCATION)
                .run(args);
    }

}
