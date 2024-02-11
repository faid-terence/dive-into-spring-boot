package com.faidterence.springbootlearn;

import com.faidterence.springbootlearn.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class SpringBootLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLearnApplication.class, args);
	}


}
