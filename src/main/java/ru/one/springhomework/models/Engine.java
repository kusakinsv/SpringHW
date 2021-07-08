package ru.one.springhomework.models;
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
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Manual> manuals;


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

    public List<Manual> getManuals() {
        return manuals;
    }

    public void setManuals(List<Manual> manuals) {
        this.manuals = manuals;
    }

    public Engine() {
    }

    public Engine(Long id, String type, List<Gear> gears, List<Manual> manuals) {
        this.id = id;
        this.type = type;
        this.gears = gears;
        this.manuals = manuals;
    }
}