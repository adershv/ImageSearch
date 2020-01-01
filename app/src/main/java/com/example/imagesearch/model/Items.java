package com.example.imagesearch.model;

import com.google.gson.annotations.SerializedName;

public class Items {

    @SerializedName("image")
    private Image image;

    @SerializedName("link")
    private String link;

    public Items(Image image, String link) {
        this.image = image;
        this.link = link;
    }

    public Items() {
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
