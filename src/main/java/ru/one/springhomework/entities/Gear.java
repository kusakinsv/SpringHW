package ru.one.springhomework.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
public class Gear {
    @Id
    @GeneratedValue
    private Long id;

    private int size;
    @ManyToOne
    @JoinColumn(name = "ENGINE_ID", referencedColumnName = "ID")
    private Engine engine;

    public Gear() {
    }

    public Gear(Long id, int size) {
        this.id = id;
        this.size = size;
    }

    public Gear(Long id, int size, Engine engine) {
        this.id = id;
        this.size = size;
        this.engine = engine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

@Override
public String toString(){
    return "";
}
}

