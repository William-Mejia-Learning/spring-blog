package com.codeup.springblog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "chew_toys")
public class ChewToy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String brand;

    private boolean isDestroyed;

    // pet object that the chew toy belong to
    @ManyToOne
    @JoinColumn(name = "pet_id")
    @JsonBackReference
    private Pet pet;

    public ChewToy() {
    }


    public ChewToy(String name, String brand, boolean isDestroyed, Pet pet) {
        this.name = name;
        this.brand = brand;
        this.isDestroyed = isDestroyed;
        this.pet = pet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean getIsDestroyed() {
        return isDestroyed;
    }

    public void setIsDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
