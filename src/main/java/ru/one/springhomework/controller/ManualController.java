package ru.one.springhomework.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.one.springhomework.entities.Engine;
import ru.one.springhomework.entities.Manual;
import ru.one.springhomework.entities.SteeringWheel;
import ru.one.springhomework.services.ServiceForEngine;
import ru.one.springhomework.services.ServiceForManual;

import java.util.HashMap;

public class ManualController {
    ServiceForManual serviceForManual;

    ManualController(ServiceForManual serviceForManual){
        this.serviceForManual = serviceForManual;
    }


    @PostMapping("create")
    public ResponseEntity create(@RequestBody Manual manual) {
        serviceForManual.addManual(manual);
        System.out.println(manual.getType() + " created");
        return ResponseEntity.ok(manual);
    }

    @GetMapping(value ={"read","read/{id}"})
    public ResponseEntity readManual(@PathVariable(name = "id", required = false) Long id) {
        if (id != null) {
            return ResponseEntity.ok(serviceForManual.findManualById(id));
        } else {
            return ResponseEntity.ok(serviceForManual.findAll());
        }
    }

    @PostMapping(value ={"update","update/{id}"}, consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateManual(@RequestBody Manual manual, @PathVariable(name = "id", required = false) Long id) {
        serviceForManual.updateManual(id, manual.getType());
        return ResponseEntity.ok((new HashMap<String, String>() {{
            put("system", "SW id "  + id + " UPDATED TO " + manual.getType());
        }}));
    }
    @PostMapping(value ={"delete", "delete/{id}"}, consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity deleteManual(@RequestBody Manual manual, @PathVariable(name = "id", required = false) Long id) {
        serviceForManual.deleteManual(id);
        return ResponseEntity.ok((new HashMap<String, String>() {{
            put("system", "SW id " + id + " DELETED");
        }}));
    }
}
