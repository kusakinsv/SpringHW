package ru.one.springhomework.services;

import ru.one.springhomework.entities.Gear;
import ru.one.springhomework.entities.SteeringWheel;

import java.util.List;

public interface ServiceForSW {
    void addSW(SteeringWheel steeringWheel);
    SteeringWheel findSWById(Long id);
    List<SteeringWheel> findAll();
    void deleteSW(Long id);
    SteeringWheel updateSW(Long id, String type);
}
