package ru.one.springhomework.services;

import ru.one.springhomework.entities.Gear;
import ru.one.springhomework.entities.SteeringWheel;

import java.util.List;

public interface ServiceForSW {
    void addSW(SteeringWheel steeringWheel);
    void deleteSW(Long id);
    SteeringWheel findSWById(Long id);
    List<SteeringWheel> findAll();
    SteeringWheel updateSW(Long id, String type);
}
