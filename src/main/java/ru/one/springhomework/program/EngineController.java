package ru.one.springhomework.program;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.one.springhomework.models.Engine;
import ru.one.springhomework.models.Gear;
import ru.one.springhomework.models.Manual;
import ru.one.springhomework.services.ServiceForEngine;

import java.util.List;
import java.util.Objects;

@RequestMapping(value = "/api/engine", consumes = {MediaType.ALL_VALUE},
                                        produces = MediaType.APPLICATION_JSON_VALUE)
public class EngineController {

    private ServiceForEngine serviceForEngine;
    private ObjectMapper objectMapper;

    @Autowired
    public EngineController(ServiceForEngine serviceForEngine, ObjectMapper objectMapper) {
        this.serviceForEngine = serviceForEngine;
        this.objectMapper = objectMapper;
    }




    @PostMapping("create")
    public Engine create(@RequestBody Engine engine) {
        serviceForEngine.addEngine(engine);
        return engine;
    }
    @GetMapping("read")
    public List<Engine> readAll(){
        return serviceForEngine.findAllEngines();
    }

    @GetMapping("read/{id}")
    public Engine readById(@PathVariable Long id) {
        return serviceForEngine.findEngineById(id);
    }

    @PostMapping(value = {"update/",
                            "update/{id}"})
    public Engine updateById(@PathVariable(required = false) Long id, @RequestBody Engine engine) {
        if (Objects.isNull(id))
            throw new RuntimeException("Error: empty id");
        String type = engine.getType();
        List<Gear> gears = engine.getGears();
        List<Manual> manuals = engine.getManuals();
        Engine updateEngine = serviceForEngine.updateById(id, type, gears, manuals);
        return updateEngine;
    }

    @PostMapping("delete/{id}")
    public Engine delete(@PathVariable Long id) {
        Engine engine = serviceForEngine.findEngineById(id);
        serviceForEngine.delete(id);
        return engine;
    }
}
