package ru.one.springhomework.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.one.springhomework.models.Engine;

@Repository
public interface EngineRepo extends CrudRepository<Engine, Long> {


}
