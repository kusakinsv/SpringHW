package ru.one.springhomework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.one.springhomework.entities.Engine;
import ru.one.springhomework.repos.EngineRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class ServiceForEngineImpl implements ServiceForEngine {

        EngineRepository engineRepository;
        @Autowired
        public ServiceForEngineImpl(EngineRepository engineRepository) {
            this.engineRepository = engineRepository;
        }

        @Override
        public void addEngine(Engine steeringWheel) {
            engineRepository.save(steeringWheel);
        }

        @Override
        public Engine findEngineById(Long id) {
            return engineRepository.findById(id).get();
        }

        @Override
        public List<Engine> findAll(){
            List<Engine> allEngines = new ArrayList<>();
            engineRepository.findAll().forEach(x -> allEngines.add(x));
            return allEngines;
        }

        @Override
        public Engine updateEngine(Long id, String type) {
            Engine engine = engineRepository.findById(id).get();
            engine.setType(type);
            engineRepository.save(engine);
            return engine;
        }

        @Override
        public void deleteEngine(Long id) {
            Engine engine = engineRepository.findById(id).get();
            engineRepository.delete(engine);
        }
    }

