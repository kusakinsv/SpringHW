package ru.one.springhomework.models;
import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue
    private Long id;
    private String manufacturer;
    private String model;

    @OneToOne(cascade = CascadeType.ALL)
    private Engine engine;
    @OneToOne(cascade = CascadeType.ALL)
    private SteeringWheel steeringWheel;

    public Car() {
    }

    public Car(Long id, String manufacturer, String model, Engine engine, SteeringWheel steeringWheel) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.engine = engine;
        this.steeringWheel = steeringWheel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public SteeringWheel getSteeringWheel() {
        return steeringWheel;
    }

    public void setSteeringWheel(SteeringWheel steeringWheel) {
        this.steeringWheel = steeringWheel;
    }
}
