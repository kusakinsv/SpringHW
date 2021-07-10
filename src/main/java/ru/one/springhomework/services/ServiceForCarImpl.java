package ru.one.springhomework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.one.springhomework.entities.Car;
import ru.one.springhomework.entities.Engine;
import ru.one.springhomework.repos.CarRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class ServiceForCarImpl implements ServiceForCar {
    CarRepository carRepository;
    @Autowired
    public ServiceForCarImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void addCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public Car findCarById(Long id) {
        return carRepository.findById(id).get();
    }


    @Override
    public List<Car> findAll(){
        List<Car> allCars = new ArrayList<>();
        carRepository.findAll().forEach(x -> allCars.add(x));
        return allCars;
    }

    @Override
    public Car updateCar(Long id, String modelName, String mnfName, Engine engineType) {
        Car car = carRepository.findById(id).get();
        car.setModelName(modelName);
        car.setMnfName(mnfName);
        car.setEngine(engineType);
        return car;
    }

    @Override
    public void deleteCar(Long id) {
        Car car = carRepository.findById(id).get();
        carRepository.delete(car);
    }


}
