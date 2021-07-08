package ru.one.springhomework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.one.springhomework.program.CarController;

@SpringBootApplication
public class SpringHomeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHomeworkApplication.class, args);
		System.out.println("***********************");
		System.out.println("* Application Started *");
		System.out.println("***********************");
	}

}
