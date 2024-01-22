package com.example.jazik.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonProperty("source_id")
    private String sourceId;
    private String name;
    @JsonProperty("house_colours")
    private String houseColours;
    private String founder;
    private String animal;
    private String element;
    private String ghost;
    @JsonProperty("common_room")
    private String commonRoom;
    @OneToMany(mappedBy = "house", cascade = CascadeType.ALL)
    private List<Head> heads;
    @OneToMany(mappedBy = "house", cascade = CascadeType.ALL)
    private List<Trait> traits;


    public int getId() {
        return id;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHouseColours() {
        return houseColours;
    }

    public void setHouseColours(String houseColours) {
        this.houseColours = houseColours;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getGhost() {
        return ghost;
    }

    public void setGhost(String ghost) {
        this.ghost = ghost;
    }

    public String getCommonRoom() {
        return commonRoom;
    }

    public void setCommonRoom(String commonRoom) {
        this.commonRoom = commonRoom;
    }

    public List<Head> getHeads() {
        return heads;
    }

    public void setHeads(List<Head> heads) {
        this.heads = heads;
    }

    public List<Trait> getTraits() {
        return traits;
    }

    public void setTraits(List<Trait> traits) {
        this.traits = traits;
    }
}
