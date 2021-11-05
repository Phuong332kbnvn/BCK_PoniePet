package com.example.bck_poniepet.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {
    @SerializedName("image")
    @Expose
    String image;

    @SerializedName("name")
    @Expose
    String name;

    @SerializedName("price")
    @Expose
    int price;

    @SerializedName("saleprice")
    @Expose
    int saleprice;

    @SerializedName("count")
    @Expose
    int count;

    @SerializedName("infor")
    @Expose
    String infor;

    public Product(String image, String name, int price) {
        this.image = image;
        this.name = name;
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(int saleprice) {
        this.saleprice = saleprice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getInfor() {
        return infor;
    }

    public void setInfor(String infor) {
        this.infor = infor;
    }
}
