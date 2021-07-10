package ru.one.springhomework.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;


@Entity
public class Manual {

        @Id
        @GeneratedValue
        private Long id;

        String type;


      @ManyToMany(cascade = CascadeType.ALL)
      List<Engine> engines;

        public Manual(Long id, String type, List<Engine> engines) {
            this.id = id;
            this.type  = type;
            this.engines = engines;
        }

    public Manual(Long id, String type) {
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

    public List<Engine> getEngines() {
        return engines;
    }

    public void setEngines(List<Engine> engines) {
        this.engines = engines;
    }

    public Manual() {
    }
}


