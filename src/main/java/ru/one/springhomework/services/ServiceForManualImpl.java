package ru.one.springhomework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.one.springhomework.entities.Manual;
import ru.one.springhomework.entities.SteeringWheel;
import ru.one.springhomework.repos.ManualRepository;


import java.util.ArrayList;
import java.util.List;
@Service
public class ServiceForManualImpl implements ServiceForManual {
    ManualRepository manualRepository;
    @Autowired
    public ServiceForManualImpl(ManualRepository manualRepository) {
        this.manualRepository = manualRepository;
    }

    @Override
    public void addManual(Manual manual) {
        manualRepository.save(manual);
    }

    @Override
    public Manual findManualById(Long id) {
        return manualRepository.findById(id).get();
    }

    @Override
    public List<Manual> findAll(){
        List<Manual> allManual = new ArrayList<>();
        manualRepository.findAll().forEach(x -> allManual.add(x));
        return allManual;
    }

    @Override
    public Manual updateManual(Long id, String type) {
        Manual manual = manualRepository.findById(id).get();
        manual.setType(type);
        manualRepository.save(manual);
        return manual;
    }

    @Override
    public void deleteManual(Long id) {
        Manual manual = manualRepository.findById(id).get();
        manualRepository.delete(manual);
    }
}
