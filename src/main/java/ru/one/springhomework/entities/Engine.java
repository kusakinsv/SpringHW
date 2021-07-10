package ru.one.springhomework.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
public class Engine {

    @Id
    @GeneratedValue
    private Long id;

    private String type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "engine")
    private List<Gear> gears;

    public Engine() {
    }

    public Engine(Long id, String type, List<Gear> gears) {
        this.id = id;
        this.type = type;
        this.gears = gears;
    }

    public Engine(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Gear> getGears() {
        return gears;
    }

    public void setGears(List<Gear> gears) {
        this.gears = gears;
    }

    @Override
    public String toString(){
        return "";
    }
}
