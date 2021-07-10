package ru.one.springhomework.repos;

import org.springframework.data.repository.CrudRepository;
import ru.one.springhomework.entities.Engine;

public interface EngineRepository extends CrudRepository<Engine, Long> {
}
