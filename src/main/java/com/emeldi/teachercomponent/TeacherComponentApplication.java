package com.emeldi.teachercomponent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TeacherComponentApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeacherComponentApplication.class, args);
	}

}
