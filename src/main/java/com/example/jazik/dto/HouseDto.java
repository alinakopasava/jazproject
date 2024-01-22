package com.example.jazik.dto;

import java.util.List;

public class HouseDto {
    private String id;
    private String name;
    private String houseColours;
    private String founder;
    private String animal;
    private String element;
    private String ghost;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String commonRoom;
    private List<HeadDto> heads;
    private List<TraitDto> traits;

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

    public List<HeadDto> getHeads() {
        return heads;
    }

    public void setHeads(List<HeadDto> heads) {
        this.heads = heads;
    }

    public List<TraitDto> getTraits() {
        return traits;
    }

    public void setTraits(List<TraitDto> traits) {
        this.traits = traits;
    }
}
