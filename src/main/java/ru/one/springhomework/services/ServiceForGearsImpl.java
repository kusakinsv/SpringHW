package ru.one.springhomework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.one.springhomework.entities.Gear;
import ru.one.springhomework.entities.SteeringWheel;
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
        List<Gear> allGears = new ArrayList<>();
        gearsRepository.findAll().forEach(x -> allGears.add(x));
        return allGears;
    }

    @Override
    public Gear updateGear(Long id, int size) {
        Gear gear = gearsRepository.findById(id).get();
        gear.setSize(size);
        gearsRepository.save(gear);
        return gear;
    }
    @Override
    public void deleteGear(Long id) {
        Gear gear = gearsRepository.findById(id).get();
        gearsRepository.delete(gear);
    }

    @Override
    public Gear findGearById(Long engineId) {
        return gearsRepository.findById(engineId).get();
    }


}
