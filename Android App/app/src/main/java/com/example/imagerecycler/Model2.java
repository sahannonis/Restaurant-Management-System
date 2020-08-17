package com.example.imagerecycler;

public class Model2 {//this model is to get prices of medium pizzas.
    private String name;
    private String imagename;
    private String description;
    private  String large;
    private  String small;
    private String medium;
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Model2(String name, String price, String description, String imagename) {//this is what will go to firebase
        this.name = name;
        this.imagename = imagename;
        this.description = description;
        this.price = price;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public Model2() {
    }
}
