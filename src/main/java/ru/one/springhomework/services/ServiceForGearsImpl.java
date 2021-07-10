package ru.one.springhomework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.one.springhomework.entities.Car;
import ru.one.springhomework.entities.Gear;
import ru.one.springhomework.repos.GearsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceForGearsImpl implements ServiceForGears{

    GearsRepository gearsRepository;

    @Autowired
    ServiceForGearsImpl(GearsRepository gearsRepository){
        this.gearsRepository = gearsRepository;
    }

    public void addGear(Gear gear) {
        gearsRepository.save(gear);
    }
    @Override
    public List<Gear> findAll(){
        List<Gear> allgears = (List<Gear>) gearsRepository.findAll();
        return allgears;
    }

    @Override
    public Gear findGearByEngineId(Long engineId) {
        return null;
    }

    @Override
    public Gear findGearById(Long engineId) {
        return gearsRepository.findById(engineId).get();
    }

    @Override
    public List<Gear> findAllById(Long id) {
        return null;
    }

}
