package ru.one.springhomework.repos;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.one.springhomework.models.Car;

@Repository
public interface CarRepo extends CrudRepository<Car, Long> {


}
