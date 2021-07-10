package ru.one.springhomework.services;

import ru.one.springhomework.entities.Car;
import ru.one.springhomework.entities.Engine;

import java.util.List;

public interface ServiceForCar{
    void addCar(Car car);
    Car findCarById(Long id);
    List<Car> findAll();
    void deleteCar(Long id);
    Car updateCar(Long id, String modelName, String mnfName, Engine engineType);
}
