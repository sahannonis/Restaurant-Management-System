package com.example.imagerecycler;

public class Model3 {//this model is to get prices of small pizzas.
    private String name;
    private String imagename;
    private String description;
    private String small;
    private String price;

    public Model3(String name, String price, String description, String imagename) {//the values that will go to firebase.
        this.name = name;
        this.imagename = imagename;
        this.description = description;
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public Model3() {
    }
}
