package ru.one.springhomework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.one.springhomework.entities.Car;
import ru.one.springhomework.entities.Engine;
import ru.one.springhomework.entities.Gear;


import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringHomeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHomeworkApplication.class, args);
		System.out.println("***********************");
		System.out.println("* Application Started *");
		System.out.println("***********************");

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Configuration.class);
//		CarRepository carRepository = applicationContext.getBean(CarRepository.class);
//		carRepository.save(new Car(null, "Ford", "Focus"));
//		carRepository.save(new Car(null, "Lada", "Priora"));
//		carRepository.save(new Car(null, "Kia", "Sorento"));
//		final Car fordCar = carRepository.findCarByMnfName("Ford");
//		final List<Car> fordCars = carRepository.findCarsByMnfName("Ford");
//		List<Car> fordCars = carRepository.findCarByMnfName("Ford");

//		final List<Car> allCars = (List<Car>) carRepository.findAll().forEach(x -> System.out.println());
//		List<Gear> gears = new ArrayList<>();
//		gears.add(new Gear (null, 5));
//		gears.add(new Gear (null, 10));
//		gears.add(new Gear (null, 12));
//		final Engine petrolEngine = new Engine(null, "V8 Petrol engine", gears);
//
//		final Car car = new Car(null, "Ford", "Focus", petrolEngine);
//
//		System.out.println("Operations Complete");
//		carRepository.save(car);
	}

}
