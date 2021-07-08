package ru.one.springhomework.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.one.springhomework.models.SteeringWheel;
import ru.one.springhomework.services.ServiceForSteeringWheel;
import java.util.List;
import java.util.Objects;

@RequestMapping(value = "/api/steeringWheel", consumes = {MediaType.ALL_VALUE},
                                                produces = MediaType.APPLICATION_JSON_VALUE)
public class SteeringWheelController {
    private ServiceForSteeringWheel serviceForSteeringWheel;

    @Autowired
    public SteeringWheelController(ServiceForSteeringWheel serviceForSteeringWheel) {
        this.serviceForSteeringWheel = serviceForSteeringWheel;
    }


    @PostMapping("create")
    public SteeringWheel create(@RequestBody SteeringWheel steeringWheel) {
        serviceForSteeringWheel.addSteeringWheel(steeringWheel);
        return steeringWheel;
    }

    @GetMapping("read/{id}")
    public SteeringWheel readById(@PathVariable Long id) {
        return serviceForSteeringWheel.findSWById(id);
    }
    @GetMapping("read")
    public List<SteeringWheel> readAll() {
        return serviceForSteeringWheel.findAllSW();
    }

    @PostMapping(value = {"update/",
                            "update/{id}"})
    public SteeringWheel updateById(@PathVariable(required = false) Long id, @RequestBody SteeringWheel steeringWheel) {
        if (Objects.isNull(id))
            throw new RuntimeException("Error: empty id");
        String type = steeringWheel.getType();
        final SteeringWheel updatedSteeringWheel = serviceForSteeringWheel.updateById(id, type);
        return updatedSteeringWheel;
    }
    @PostMapping("delete/{id}")
    public SteeringWheel delete(@PathVariable Long id) {
        SteeringWheel steeringWheel = serviceForSteeringWheel.findSWById(id);
        serviceForSteeringWheel.delete(id);
        return steeringWheel;
    }
}

