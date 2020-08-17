package com.example.imagerecycler;

public class Model1 {//this model is to get prices of large pizzas.
    private String name;
    private String medium;
    private String imagename;
    private String large;
    private String price;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Model1(String name, String price, String description, String imagename) {//this is what will go to the database
        this.name = name;

        this.imagename = imagename;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String description) {
        this.imagename = description;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public void Model1(){

    }
}
