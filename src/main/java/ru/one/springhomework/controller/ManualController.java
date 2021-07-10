package ru.one.springhomework.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.one.springhomework.entities.Manual;
import ru.one.springhomework.services.ServiceForManual;

/*            {"type": "Cylinder head manual for petrol",
            "engines":[
            {"type": "V8 petrol engine"},
            {"type": "V12 petrol engine"},
						{"type": "R4 petrol engine"}
            ]}
 */


import java.util.HashMap;
@RestController
@RequestMapping(value = "/api/manual", consumes = {MediaType.ALL_VALUE},
        produces = MediaType.APPLICATION_JSON_VALUE)
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
    public ResponseEntity updateManual(@RequestBody Manual manual, @PathVariable(name = "id", required = false) Long id) throws Exception {
        if (id == null) throw new Exception("Error: empty id");
        serviceForManual.updateManual(id, manual.getType());
        return ResponseEntity.ok((new HashMap<String, String>() {{
            put("system", "Manual id "  + id + " UPDATED TO " + manual.getType());
        }}));
    }
    @PostMapping(value ={"delete", "delete/{id}"}, consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity deleteManual(@RequestBody Manual manual, @PathVariable(name = "id", required = false) Long id) throws Exception {
        if (id == null) throw new Exception("Error: empty id");
        serviceForManual.deleteManual(id);
        return ResponseEntity.ok((new HashMap<String, String>() {{
            put("system", "SW id " + id + " DELETED");
        }}));
    }
}
