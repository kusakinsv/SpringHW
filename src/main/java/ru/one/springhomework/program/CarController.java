package ru.one.springhomework.program;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.one.springhomework.models.Car;
import ru.one.springhomework.models.Engine;
import ru.one.springhomework.models.SteeringWheel;
import ru.one.springhomework.services.ServiceForCar;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/api/car", consumes = {MediaType.ALL_VALUE},
                                    produces = MediaType.APPLICATION_JSON_VALUE)

    public class CarController {

        private ServiceForCar serviceForCar;
        private ObjectMapper objectMapper;

        @Autowired
        public CarController(ServiceForCar serviceForCar, ObjectMapper objectMapper) {
            this.serviceForCar = serviceForCar;
            this.objectMapper = objectMapper;
        }

        @PostMapping("create")
        public Car create(@RequestBody Car car){
            serviceForCar.addCar(car);
            return car;
        }

        @GetMapping("read/{id}")
        public Car readById(@PathVariable Long id) {
            return serviceForCar.findCarById(id);
        }


        @GetMapping("read")
        public List<Car> readAll() {
            return serviceForCar.findAllCars();
        }


        @PostMapping(value = {"update/",
                                "update/{id}"})
        public Car updateById(@PathVariable(required = false) Long id, @RequestBody Car car) {
            if (Objects.isNull(id)) throw new RuntimeException("Error: empty id");
            String manufacturer = car.getManufacturer();
            String model = car.getModel();
            Engine engine = car.getEngine();
            SteeringWheel steeringWheel = car.getSteeringWheel();
            Car updatedCar = serviceForCar.updateById(id, manufacturer, model, engine, steeringWheel);
            return updatedCar;
        }

        @PostMapping("car/delete/{id}")
        public Car delete(@PathVariable Long id) {
            Car car = serviceForCar.findCarById(id);
            serviceForCar.delete(id);
            return car;
        }

    }


