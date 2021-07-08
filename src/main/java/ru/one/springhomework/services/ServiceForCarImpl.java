package ru.one.springhomework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.one.springhomework.models.Car;
import ru.one.springhomework.models.Engine;
import ru.one.springhomework.models.SteeringWheel;
import ru.one.springhomework.repos.CarRepo;

import java.util.List;
@Service
public class ServiceForCarImpl implements ServiceForCar {
    public CarRepo carRepo;
    @Autowired
    public ServiceForCarImpl(CarRepo carRepo){ //
        this.carRepo = carRepo;
    }


    @Override
    public void addCar(Car car) {
        carRepo.save(car);
    }

    @Override
    public List<Car> findAllCars() {
        return (List<Car>) carRepo.findAll();
    }

    @Override
    public Car findCarById(Long carId) {
        return carRepo.findById(carId).get();
    }

    @Override
    public Car updateById(Long carId, String manufacturer, String model, Engine engine, SteeringWheel steeringWheel) {
        Car car = carRepo.findById(carId).get();
        car.setManufacturer(manufacturer);
        car.setModel(model);
        car.setEngine(engine);
        car.setSteeringWheel(steeringWheel);
        carRepo.save(car);
        return car;
    }

    @Override
    public void delete(Long carId) {
        carRepo.delete(findCarById(carId));

    }

}
