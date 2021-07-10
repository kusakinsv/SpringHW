package ru.one.springhomework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.one.springhomework.entities.Gear;
import ru.one.springhomework.entities.SteeringWheel;
import ru.one.springhomework.repos.SWRepository;

import java.util.List;
@Service
public class ServiceForSWImpl implements ServiceForSW {
    SWRepository swRepository;

    public ServiceForSWImpl(SWRepository swRepository) {
        this.swRepository = swRepository;
    }

    @Override
    public void addSW(SteeringWheel steeringWheel) {
    swRepository.save(steeringWheel);
    }

    @Override
    public SteeringWheel findSWById(Long id) {
        return swRepository.findById(id).get();
    }
    @Override
    public List<SteeringWheel> findAll(){
        List<SteeringWheel> allSW = (List<SteeringWheel>) swRepository.findAll();
        return allSW;
    }

//    public void updateSW(SteeringWheel steeringWheel, Long id){
//        steeringWheel.setType();
//    }

    @Override
    public SteeringWheel updateSW(Long id, String type) {
        SteeringWheel steeringWheel = swRepository.findById(id).get();
        steeringWheel.setType(type);
        swRepository.save(steeringWheel);
        return steeringWheel;
    }

    @Override
    public void deleteSW(Long id) {
        SteeringWheel steeringWheel = swRepository.findById(id).get();
        swRepository.delete(steeringWheel);
    }






}
