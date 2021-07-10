package ru.one.springhomework.entities;
import javax.persistence.*;


/*
{
	"mnfName": "Tesla",
	"modelName": "Model S",
	"engine": {
	                "type": "electrical engine"
}}
*/

@Entity
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
    private Engine engine;

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
        return mnfName + " " + modelName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMnfName() {
        return mnfName;
    }

    public void setMnfName(String mnfName) {
        this.mnfName = mnfName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

}
