package ru.one.springhomework.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class Gear {
    @Id
    @GeneratedValue
    private Long id;
    private int size;


    public Gear() {
    }

    public Gear(Long id, int size) {
        this.id = id;
        this.size = size;
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

