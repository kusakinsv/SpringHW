package ru.one.springhomework.repos;

import org.springframework.data.repository.CrudRepository;
import ru.one.springhomework.entities.SteeringWheel;

public interface SWRepository extends CrudRepository<SteeringWheel, Long> {
}
