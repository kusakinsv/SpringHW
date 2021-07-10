package ru.one.springhomework.repos;

import org.springframework.data.repository.CrudRepository;
import ru.one.springhomework.entities.Car;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {
//    Car findCarByMnfName(String mnfName);
    List<Car> findCarByMnfName(String mnfName);
    List<Car> findCarByMnfNameAndModelName(String mnfName, String modelName);

}
