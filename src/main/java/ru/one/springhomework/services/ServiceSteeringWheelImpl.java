package ru.one.springhomework.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.one.springhomework.models.Engine;
import ru.one.springhomework.models.Manual;
import ru.one.springhomework.models.SteeringWheel;
import ru.one.springhomework.repos.SteeringWheelRepo;

import java.util.List;

@Service
public class ServiceSteeringWheelImpl implements ServiceForSteeringWheel {

    private ServiceForSteeringWheel serviceForSteeringWheel;
    private SteeringWheelRepo steeringWheelRepo;
    @Autowired
    public ServiceSteeringWheelImpl(SteeringWheelRepo steeringWheelRepo) {
        this.steeringWheelRepo = steeringWheelRepo;
    }
    @Override
    public SteeringWheel findSWById(Long stWId) {
        return steeringWheelRepo.findById(stWId).get();
    }

    @Override
    public List<SteeringWheel> findAllSW() {
        return (List<SteeringWheel>) steeringWheelRepo.findAll();
    }

    @Override
    public void addSteeringWheel(SteeringWheel steeringWheel) {
        steeringWheelRepo.save(steeringWheel);
    }


    @Override
    public SteeringWheel updateById(Long stWId, String type) {
        SteeringWheel steeringWheel = steeringWheelRepo.findById(stWId).get();
        steeringWheel.setType(type);
        steeringWheelRepo.save(steeringWheel);
        return steeringWheel;
    }

    @Override
    public void delete(Long stWId) {
        steeringWheelRepo.delete(findSWById(stWId));
    }

    }

