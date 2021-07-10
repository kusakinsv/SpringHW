package ru.one.springhomework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.one.springhomework.entities.Gear;
import ru.one.springhomework.entities.SteeringWheel;
import ru.one.springhomework.services.ServiceForGears;
import ru.one.springhomework.services.ServiceForSW;

import java.util.HashMap;

/*     {
         "type": "Steering wheel for Ford Focus"
         }
*/


@RestController
@RequestMapping(value = "/api/sw", consumes = {MediaType.ALL_VALUE},
        produces = MediaType.APPLICATION_JSON_VALUE)

public class SWController {
    // GearsRepository gearsRepository;
    ServiceForSW serviceForSW;

    @Autowired
    public SWController(ServiceForSW serviceForSW) {
        this.serviceForSW = serviceForSW;
    }

    @PostMapping("create")
    public ResponseEntity create(@RequestBody SteeringWheel steeringWheel) {
        serviceForSW.addSW(steeringWheel);
        System.out.println(steeringWheel.getType() + " created");
        return ResponseEntity.ok(steeringWheel);
    }

    @GetMapping(value ={"read","read/{id}"})
    public ResponseEntity readSW(@PathVariable(name = "id", required = false) Long id) {
        if (id != null) {
            return ResponseEntity.ok(serviceForSW.findSWById(id));
        } else {
            return ResponseEntity.ok(serviceForSW.findAll());
        }
    }

           @PostMapping(value ={"update","update/{id}"}, consumes = {MediaType.APPLICATION_JSON_VALUE},
                produces = {MediaType.APPLICATION_JSON_VALUE})
        public ResponseEntity updateSteeringWheel(@RequestBody SteeringWheel steeringWheel, @PathVariable(name = "id", required = false) Long id) {
            serviceForSW.updateSW(id, steeringWheel.getType());
        return ResponseEntity.ok((new HashMap<String, String>() {{
            put("system", "SW id "  + id + " UPDATED TO " + steeringWheel.getType());
        }}));
    }
    @PostMapping(value ={"delete", "delete/{id}"}, consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity deleteSteeringWheel(@RequestBody SteeringWheel steeringWheel, @PathVariable(name = "id", required = false) Long id) {
        serviceForSW.deleteSW(id);
        return ResponseEntity.ok((new HashMap<String, String>() {{
            put("system", "SW id " + id + " DELETED");
        }}));
    }

}
