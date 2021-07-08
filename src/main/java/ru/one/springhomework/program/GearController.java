package ru.one.springhomework.program;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.one.springhomework.models.Engine;
import ru.one.springhomework.models.Gear;
import ru.one.springhomework.services.ServiceForGear;

import java.util.List;
import java.util.Objects;
@RequestMapping(value = "/api/gear", consumes = {MediaType.ALL_VALUE},
                                        produces = MediaType.APPLICATION_JSON_VALUE)
public class GearController {
    private ServiceForGear serviceForGear;

    @Autowired
    public GearController(ServiceForGear serviceForGear) {
        this.serviceForGear = serviceForGear;
    }


    @PostMapping("create")
    public Gear create(@RequestBody Gear gear) {
        serviceForGear.addGear(gear);
        return gear;
    }
    @GetMapping("read/{id}")
    public Gear readById(@PathVariable Long id) {
        return serviceForGear.findCarById(id);
    }

    @GetMapping("read")
    public List<Gear> readAll() {
        return serviceForGear.findAllGears();
    }

    @PostMapping(value = {"update/",
                            "update/{id}"})
    public Gear updateById(@PathVariable(required = false) Long id, @RequestBody Gear gear) {
        if (Objects.isNull(id))
            throw new RuntimeException("Error: empty id");
        Long gearSize = gear.getGearSize();
        Engine engine = gear.getEngine();
        return serviceForGear.updateById(id,gearSize,engine);
    }

    @PostMapping("delete/{id}")
    public Gear delete(@PathVariable Long id) {
        Gear gear = serviceForGear.findCarById(id);
        serviceForGear.delete(id);
        return gear;
    }
}
