package ru.one.springhomework.models;
import javax.persistence.*;
import java.util.List;

@Entity
public class Manual {
    @Id
    @GeneratedValue
    private Long id;

    private String type;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "manuals")
    List<Engine> engines;

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

    public Manual(Long id, String type, List<Engine> engines) {
        this.id = id;
        this.type = type;
        this.engines = engines;
    }
}
