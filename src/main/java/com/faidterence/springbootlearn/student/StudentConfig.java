package com.faidterence.springbootlearn.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return  args -> {
            Student faid = new Student(1,
                    "Terence",
                    "terence@outlook.com",
                    LocalDate.of(2002, Month.MAY, 13)
            );
            Student jABO = new Student(2,
                    "JABO",
                    "jabo@outlook.com",
                    LocalDate.of(2002, Month.MAY, 13)
            );

            repository.saveAll(
                    List.of(faid, jABO)
            );
        };
    }

}
