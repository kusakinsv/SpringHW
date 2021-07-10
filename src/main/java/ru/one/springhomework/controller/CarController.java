package ru.one.springhomework.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.one.springhomework.entities.Car;
import ru.one.springhomework.entities.SteeringWheel;
import ru.one.springhomework.services.ServiceForCar;


import java.util.HashMap;
@RestController
@RequestMapping(value = "/api/car", consumes = {MediaType.ALL_VALUE},
        produces = MediaType.APPLICATION_JSON_VALUE)

public class CarController {
    ServiceForCar serviceForCar;

    CarController(ServiceForCar serviceForCar){
        this.serviceForCar = serviceForCar;
    }


    @PostMapping("create")
    public ResponseEntity create(@RequestBody Car car) {
        serviceForCar.addCar(car);
        System.out.println(car.getMnfName()+ " " + car.getModelName() + " created");
        return ResponseEntity.ok(car);
    }

    @GetMapping(value ={"read","read/{id}"})
    public ResponseEntity readEngine(@PathVariable(name = "id", required = false) Long id) {
        if (id != null){
            return ResponseEntity.ok(serviceForCar.findCarById(id));
            } else {
            return ResponseEntity.ok(serviceForCar.findAll());
        }
    }

    @PostMapping(value ={"update","update/{id}"}, consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateEngine(@RequestBody Car car, @PathVariable(name = "id", required = false) Long id) throws Exception {
        if (id == null) throw new Exception("Error: empty id");
        serviceForCar.updateCar(id, car.getMnfName(), car.getMnfName(), car.getEngine());
        return ResponseEntity.ok((new HashMap<String, String>() {{
            put("system", "Car "  + id + " UPDATED TO " + car.getMnfName() + " " + car.getModelName());
        }}));
    }
    @PostMapping(value ={"delete", "delete/{id}"}, consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity deleteCar(@RequestBody SteeringWheel steeringWheel, @PathVariable(name = "id", required = false) Long id) throws Exception {
        if (id == null) throw new Exception("Error: empty id");
        serviceForCar.deleteCar(id);
        return ResponseEntity.ok((new HashMap<String, String>() {{
            put("system", "Car id " + id + " DELETED");
        }}));
    }

}
