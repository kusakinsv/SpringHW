package ru.one.springhomework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.one.springhomework.models.Engine;
import ru.one.springhomework.models.Gear;
import ru.one.springhomework.repos.GearRepo;

import java.util.List;
@Service
public class ServiceForGearImpl implements ServiceForGear {
    private GearRepo gearRepo;

    @Autowired
    public ServiceForGearImpl(GearRepo gearRepo) {
        this.gearRepo = gearRepo;
    }


    @Override
    public Gear findCarById(Long gearId) {
        return gearRepo.findById(gearId).get();
    }

    @Override
    public List<Gear> findAllGears() {
        return (List<Gear>) gearRepo.findAll();
    }

    @Override
    public void addGear(Gear gear) {
        gearRepo.save(gear);
    }

    @Override
    public Gear updateById(Long gearId, Long gearSize, Engine engine) {
        Gear gear = gearRepo.findById(gearId).get();
        gear.setGearSize(gearSize);
        gear.setEngine(engine);
        gearRepo.save(gear);
        return gear;
    }

    @Override
    public void delete(Long gearId) {
        gearRepo.delete(findCarById(gearId));
    }
}
