package ru.one.springhomework.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.one.springhomework.models.Engine;
import ru.one.springhomework.models.Manual;
import ru.one.springhomework.services.ServiceForManual;

import java.util.List;
import java.util.Objects;
@RequestMapping(value = "/api/manual", consumes = {MediaType.ALL_VALUE},
                                        produces = MediaType.APPLICATION_JSON_VALUE)
public class ManualController {
    private ServiceForManual serviceForManual;
    @Autowired
    public ManualController(ServiceForManual serviceForManual) {
        this.serviceForManual = serviceForManual;
    }

    @PostMapping("create")
    public Manual create(@RequestBody Manual manual) {
        serviceForManual.addManual(manual);
        return manual;
    }

    @GetMapping("read/{id}")
    public Manual readById(@PathVariable Long id) {
        return serviceForManual.findManualById(id);
    }
    @GetMapping("read")

    public List<Manual> readAll() {
        return serviceForManual.findAllManuals();
    }
    @PostMapping(value = {"update/",
                            "update/{id}"})
    public Manual updateById(@PathVariable(required = false) Long id, @RequestBody Manual manual) {
        if (Objects.isNull(id))
            throw new RuntimeException("Error: empty id");
        String type = manual.getType();
        List<Engine> engines = manual.getEngines();
        Manual updatedManual = serviceForManual.updateById(id, type, engines);
        return updatedManual;
    }
    @PostMapping("delete/{id}")
    public Manual delete(@PathVariable Long id) {
        Manual manual = serviceForManual.findManualById(id);
        serviceForManual.delete(id);
        return manual;
    }
}
