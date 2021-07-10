package ru.one.springhomework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.one.springhomework.entities.Gear;
import ru.one.springhomework.repos.GearsRepository;
import ru.one.springhomework.services.ServiceForGears;
import ru.one.springhomework.services.ServiceForGearsImpl;

import java.util.HashMap;
import java.util.List;
/*
        {
        "size": 10
        }
*/

@RestController
@RequestMapping(value = "/api/gear", consumes = {MediaType.ALL_VALUE},
                                    produces = MediaType.APPLICATION_JSON_VALUE)

public class GearsController {
   // GearsRepository gearsRepository;
    ServiceForGears serviceForGears;

    @Autowired
    public GearsController(ServiceForGears serviceForGears) {
        this.serviceForGears = serviceForGears;
    }

    @PostMapping("create")
    public ResponseEntity create(@RequestBody Gear gear) {
        serviceForGears.addGear(gear);
        System.out.println(gear.getSize() + " created");
        return ResponseEntity.ok(gear);
    }

    @GetMapping(value ={"read","read/{id}"})
    public ResponseEntity readGear(@PathVariable(name = "id", required = false) Long id) {
        if (id != null) {
            return ResponseEntity.ok(serviceForGears.findGearById(id));
        } else {
            return ResponseEntity.ok(serviceForGears.findAll());
        }}

        @PostMapping(value ={"update","update/{id}"}, consumes = {MediaType.APPLICATION_JSON_VALUE},
                produces = {MediaType.APPLICATION_JSON_VALUE})
        public ResponseEntity updateSteeringWheel(@RequestBody Gear gear, @PathVariable(name = "id", required = false) Long id) {
            serviceForGears.updateGear(id, gear.getSize());
            return ResponseEntity.ok((new HashMap<String, String>() {{
                put("system", "SW id "  + id + " updated to " + gear.getSize());
            }}));
        }



    }






