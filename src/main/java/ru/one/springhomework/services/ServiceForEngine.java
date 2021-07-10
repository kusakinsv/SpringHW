package ru.one.springhomework.services;

import ru.one.springhomework.entities.Engine;
import ru.one.springhomework.entities.SteeringWheel;

import java.util.List;

public interface ServiceForEngine {
    void addEngine(Engine engine);
    Engine findEngineById(Long id);
    List<Engine> findAll();
    void deleteEngine(Long id);
    Engine updateEngine(Long id, String type);
}
