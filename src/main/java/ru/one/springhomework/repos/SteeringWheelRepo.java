package ru.one.springhomework.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.one.springhomework.models.SteeringWheel;

@Repository
public interface SteeringWheelRepo extends CrudRepository<SteeringWheel, Long> {

}
