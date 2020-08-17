package com.example.imagerecycler;

public class ModelDessert {
    private String name;
    private String imagename;
    private String description;
    private  String large;
    private  String small;
    private String price;

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

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ModelDessert(String name, String price, String description, String imagename) {
        this.name = name;
        this.imagename = imagename;
        this.description = description;
        this.price = price;
    }
}
