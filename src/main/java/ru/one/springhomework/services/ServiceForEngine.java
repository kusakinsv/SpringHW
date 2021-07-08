package ru.one.springhomework.services;

import ru.one.springhomework.models.Engine;
import ru.one.springhomework.models.Gear;
import ru.one.springhomework.models.Manual;

import java.util.List;

public interface ServiceForEngine {
    List<Engine> findAllEngines();

    Engine findEngineById(Long engineId);

    void addEngine(Engine engine);

    Engine updateById(Long engineId, String type, List<Gear> gears, List<Manual> manuals);

    void delete(Long engineId);
}
