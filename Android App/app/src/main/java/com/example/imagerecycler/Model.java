package com.example.imagerecycler;

public class Model {

    private String name;
    private String imagename;
    private String description;
    private String small;
    private String medium;
    private String large;

    public Model() {
    }

    public Model(String name, String imagename, String description, String small, String medium, String large) {
        this.name = name;
        this.imagename = imagename;
        this.description = description;
        this.small = small;
        this.medium = medium;
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

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }
}
