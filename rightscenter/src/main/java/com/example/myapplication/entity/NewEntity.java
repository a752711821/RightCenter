package com.example.myapplication.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/21/021.
 */

public class NewEntity implements Serializable {
    String name;
    String imageUrl;
    String starLevel;
    String realBalance;
    String derdge;

    public String getDerdge() {
        return derdge;
    }

    public void setDerdge(String derdge) {
        this.derdge = derdge;
    }

    public String getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(String starLevel) {
        this.starLevel = starLevel;
    }

    public String getRealBalance() {
        return realBalance;
    }

    public void setRealBalance(String realBalance) {
        this.realBalance = realBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
