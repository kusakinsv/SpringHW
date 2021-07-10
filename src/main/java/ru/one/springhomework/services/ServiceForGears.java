package ru.one.springhomework.services;

import ru.one.springhomework.entities.Car;
import ru.one.springhomework.entities.Gear;
import ru.one.springhomework.entities.SteeringWheel;
import ru.one.springhomework.repos.GearsRepository;

import java.util.List;

public interface ServiceForGears {
void addGear(Gear gear);
Gear findGearByEngineId(Long engineId);
Gear findGearById(Long engineId);
List<Gear> findAllById(Long id);
List<Gear> findAll();
Gear updateGear(Long id, int size);



}
