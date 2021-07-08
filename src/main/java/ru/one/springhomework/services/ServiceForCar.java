package ru.one.springhomework.services;

import ru.one.springhomework.models.Car;
import ru.one.springhomework.models.Engine;
import ru.one.springhomework.models.SteeringWheel;

import java.util.List;

public interface ServiceForCar {
    void addCar(Car car);

    List<Car> findAllCars();

    Car findCarById(Long carId);

    Car updateById(Long carId, String manufacturer, String model, Engine engine, SteeringWheel steeringWheel);

    void delete(Long carId);
}
