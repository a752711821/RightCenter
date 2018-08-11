package com.example.myapplication;

/**
 * Created by Administrator on 2018/5/18/018.
 */

public class MyRecyclerViewEntity {
    private int image;
    private String title;
    private String content;
    private float priceDz;
    private float priceYj;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getPriceDz() {
        return priceDz;
    }

    public void setPriceDz(float priceDz) {
        this.priceDz = priceDz;
    }

    public float getPriceYj() {
        return priceYj;
    }

    public void setPriceYj(float priceYj) {
        this.priceYj = priceYj;
    }

    @Override
    public String toString() {
        return "MyRecyclerViewEntity{" +
                "image=" + image +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", priceDz=" + priceDz +
                ", priceYj=" + priceYj +
                '}';
    }
}
