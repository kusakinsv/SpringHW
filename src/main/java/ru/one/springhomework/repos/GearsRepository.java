package ru.one.springhomework.repos;

import org.springframework.data.repository.CrudRepository;
import ru.one.springhomework.entities.Gear;

public interface GearsRepository extends CrudRepository<Gear, Long> {

    //Gear addGear(Gear gear);
}
