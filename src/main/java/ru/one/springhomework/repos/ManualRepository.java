package ru.one.springhomework.repos;

import org.springframework.data.repository.CrudRepository;
import ru.one.springhomework.entities.Manual;

public interface ManualRepository extends CrudRepository<Manual, Long> {
}
