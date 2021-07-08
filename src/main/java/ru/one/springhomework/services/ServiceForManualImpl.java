package ru.one.springhomework.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.one.springhomework.models.Engine;
import ru.one.springhomework.models.Manual;
import ru.one.springhomework.repos.ManualRepo;

import java.util.List;

@Service
public class ServiceForManualImpl implements ServiceForManual {
    private ManualRepo manualRepo;


    @Autowired
    public ServiceForManualImpl(ManualRepo manualRepo) {
        this.manualRepo = manualRepo;
    }


    @Override
    public Manual findManualById(Long manualId) {
        return manualRepo.findById(manualId).get();
    }

    @Override
    public List<Manual> findAllManuals() {
        return (List<Manual>) manualRepo.findAll();
    }

    @Override
    public void addManual(Manual manual) {
        manualRepo.save(manual);
    }

    @Override
    public Manual updateById(Long manualId, String type, List<Engine> engines) {
        Manual manual = manualRepo.findById(manualId).get();
        manual.setType(type);
        manual.setEngines(engines);
        manualRepo.save(manual);
        return manual;
    }

    @Override
    public void delete(Long manualId) {
        manualRepo.delete(findManualById(manualId));
    }
}
