package ru.one.springhomework.services;

import ru.one.springhomework.entities.Engine;
import ru.one.springhomework.entities.Manual;

import java.util.List;

public interface ServiceForManual {
    void addManual(Manual manual);
    Manual findManualById(Long id);
    List<Manual> findAll();
    void deleteManual(Long id);
    Manual updateManual(Long id, String type);
}
