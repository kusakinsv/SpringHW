package ru.one.springhomework.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
public class Car {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "MANUFACTURER")
    private String mnfName;

    @Column(name = "MODEL")
    private String modelName;

    @OneToOne(cascade = CascadeType.ALL)
    Engine engine;

    public Car() {
    }

    public Car(Long id, String mnfName, String modelName, Engine engine) {
        this.id = id;
        this.mnfName = mnfName;
        this.modelName = modelName;
        this.engine = engine;
    }

    @Override
    public String toString(){
        return mnfName + "" + modelName;
    }
}
