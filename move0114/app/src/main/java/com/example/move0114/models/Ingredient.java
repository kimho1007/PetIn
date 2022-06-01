package com.example.move0114.models;

public class Ingredient {

    private String id;
    private String name;
    private int image;
    private int image_intro;

    public Ingredient(String id, String name, int image, int image_intro) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.image_intro = image_intro;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImage_intro() {
        return image_intro;
    }

    public void setImage_intro(int image_intro) {
        this.image_intro = image_intro;
    }
}
