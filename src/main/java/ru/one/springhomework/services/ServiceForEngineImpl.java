package ru.one.springhomework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.one.springhomework.models.Engine;
import ru.one.springhomework.models.Gear;
import ru.one.springhomework.models.Manual;
import ru.one.springhomework.repos.EngineRepo;

import java.util.List;
@Service
public class ServiceForEngineImpl  implements ServiceForEngine{
    public EngineRepo engineRepo;
    @Autowired
    public ServiceForEngineImpl(EngineRepo engineRepo){this.engineRepo = engineRepo;}


    @Override
    public List<Engine> findAllEngines() {
        return (List<Engine>) engineRepo.findAll();
    }

    @Override
    public Engine findEngineById(Long engineId) {
        return engineRepo.findById(engineId).get();
    }

    @Override
    public void addEngine(Engine engine) {
        engineRepo.save(engine);
    }

    @Override
    public Engine updateById(Long engineId, String type, List<Gear> gears, List<Manual> manuals) {
        Engine engine = engineRepo.findById(engineId).get();
        engine.setType(type);
        engine.setGears(gears);
        engine.setManuals(manuals);
        engineRepo.save(engine);
        return engine;
    }

    @Override
    public void delete(Long engineId) {
        engineRepo.delete(findEngineById(engineId));
    }
}
