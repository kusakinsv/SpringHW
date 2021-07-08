package ru.one.springhomework.services;

import ru.one.springhomework.models.SteeringWheel;

import java.util.List;

public interface ServiceForSteeringWheel {
    SteeringWheel findSWById(Long swId);

    List<SteeringWheel> findAllSW();

    void addSteeringWheel(SteeringWheel steeringWheel);

    SteeringWheel updateById(Long swId, String type);

    void delete(Long swId);
}
