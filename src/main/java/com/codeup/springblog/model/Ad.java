package com.codeup.springblog.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; //set the field for the id

    //Blank / default constructor
    public Ad(){};

    //Create constructor

    public Ad(String title, String description, User owner) {
        this.title = title;
        this.description = description;
        this.owner = owner;
    }


    //Update constructor


    //move on down to make more fields
    @Column(nullable = false, length = 50) //NOT NULL length 100? varchar(100)?
    private String title;

    @Column(nullable = false) //Not null. . no other customization
    private String description;

    @OneToOne
    private User owner;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }


}