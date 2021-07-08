package ru.one.springhomework.models;
import javax.persistence.*;

@Entity
public class Gear {

    @Id
    @GeneratedValue
    private Long id;

    private Long gearSize;

    @ManyToOne
    @JoinColumn(name = "ENGINE_ID", referencedColumnName = "ID")
    private Engine engine;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGearSize() {
        return gearSize;
    }

    public void setGearSize(Long gearSize) {
        this.gearSize = gearSize;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Gear() {
    }

    public Gear(Long id, Long gearSize, Engine engine) {
        this.id = id;
        this.gearSize = gearSize;
        this.engine = engine;
    }
}