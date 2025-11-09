package com.rkbm.ensa_coffee;

import java.io.Serializable;

public class Coffee implements Serializable {
    int id;
    String name;
    String imageURL;
    String instructions;

    // Constructors
    public Coffee() {
    }

    public Coffee(int id, String name, String imageURL, String instructions) {
        super();
        this.id = id;
        this.name = name;
        this.imageURL = imageURL;
        this.instructions = instructions;
    }

    // Getters and Setters
    public int getId() {
        return id;
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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageUrl(String imageUrl) {
        this.imageURL = imageUrl;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
