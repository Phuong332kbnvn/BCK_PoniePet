package com.example.bck_poniepet.Objects;

public class Activity {
    private int resourceImg;
    private String name;

    public Activity(int resourceImg, String name) {
        this.resourceImg = resourceImg;
        this.name = name;
    }

    public int getResourceImg() {
        return resourceImg;
    }

    public void setResourceImg(int resourceImg) {
        this.resourceImg = resourceImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
