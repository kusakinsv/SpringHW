package ru.one.springhomework.controller;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.one.springhomework.entities.Engine;
import ru.one.springhomework.services.ServiceForEngine;
import java.util.HashMap;



/*
 {"type": "V8 petrol engine",
            "gears":[
            {"size": 10},
            {"size": 15}
            ]}
 */
@RestController
@RequestMapping(value = "/api/engine", consumes = {MediaType.ALL_VALUE},
        produces = MediaType.APPLICATION_JSON_VALUE)
public class EngineController {
    ServiceForEngine serviceForEngine;

    EngineController(ServiceForEngine serviceForEngine){
        this.serviceForEngine = serviceForEngine;
    }


    @PostMapping("create")
    public ResponseEntity create(@RequestBody Engine engine) {
        serviceForEngine.addEngine(engine);
        System.out.println(engine.getType() + " created");
        return ResponseEntity.ok(engine);
    }

    @GetMapping(value ={"read","read/{id}"})
    public ResponseEntity readEngine(@PathVariable(name = "id", required = false) Long id) {
        if (id != null) {
            return ResponseEntity.ok(serviceForEngine.findEngineById(id));
            } else {
            return ResponseEntity.ok(serviceForEngine.findAll());
        }
    }

    @PostMapping(value ={"update","update/{id}"}, consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateEngine(@RequestBody Engine engine, @PathVariable(name = "id", required = false) Long id) throws Exception {
        if (id == null) throw new Exception("Error: empty id");
        serviceForEngine.updateEngine(id, engine.getType());
        return ResponseEntity.ok((new HashMap<String, String>() {{
            put("system", "Engine id "  + id + " UPDATED TO " + engine.getType());
        }}));
    }
    @PostMapping(value ={"delete", "delete/{id}"}, consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity deleteEngine(@RequestBody Engine engine, @PathVariable(name = "id", required = false) Long id) throws Exception {
        if (id == null) throw new Exception("Error: empty id");
        serviceForEngine.deleteEngine(id);
        return ResponseEntity.ok((new HashMap<String, String>() {{
            put("system", "Engine id " + id + " DELETED");
        }}));
    }

}

