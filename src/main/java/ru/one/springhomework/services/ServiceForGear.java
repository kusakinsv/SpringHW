package ru.one.springhomework.services;

import ru.one.springhomework.models.Engine;
import ru.one.springhomework.models.Gear;

import java.util.List;

public interface ServiceForGear {
    Gear findCarById(Long gearId);

    List<Gear> findAllGears();

    void addGear(Gear gear);

    Gear updateById(Long gearId, Long gearSize, Engine engine);

    void delete(Long gearId);
}
