package com.miguelprojects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SolicitudesGet {

    public static void main(String[] args) {
        SpringApplication.run(SolicitudesGet.class, args);
    }

//    @Bean
//    CommandLineRunner runner(GradeRepository repository) {
//        return args -> {
//
//            repository.findScoreGreaterThan50();
//
//        };
//    }
}
