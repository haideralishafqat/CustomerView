package com.example.support.customerview;

import java.io.Serializable;

/**
 * Created by HaiderAli on 8/21/2017.
 */
public class Product implements Serializable {

    private String name;
    private String price;
    private String quantity;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String geturl() {
        return url;
    }

    public void seturl(String imageUrl) {
        this.url = imageUrl;
    }

}
