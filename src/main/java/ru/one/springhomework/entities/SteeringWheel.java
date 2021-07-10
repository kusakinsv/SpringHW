package ru.one.springhomework.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;




@Entity
public class SteeringWheel {

@Id
@GeneratedValue
    private Long Id;

    private String type;

    public SteeringWheel(Long id, String type) {
        Id = id;
        this.type = type;
    }

    public SteeringWheel() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
