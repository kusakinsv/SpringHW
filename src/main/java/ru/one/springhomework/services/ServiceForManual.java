package ru.one.springhomework.services;

import ru.one.springhomework.models.Engine;
import ru.one.springhomework.models.Manual;

import java.util.List;

public interface ServiceForManual {
    Manual findManualById(Long manualId);

    List<Manual> findAllManuals();

    void addManual(Manual manual);

    Manual updateById(Long manualId, String type, List<Engine> engines);

    void delete(Long manualId);
}
