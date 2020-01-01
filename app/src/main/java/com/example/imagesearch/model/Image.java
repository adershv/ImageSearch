package com.example.imagesearch.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("width")
    @Expose
    private int width;

    @SerializedName("height")
    @Expose
    private int height;

    @SerializedName("contextLink")
    @Expose
    private String contextLink;

    @SerializedName("thumbnailLink")
    @Expose
    private String thumbnailLink;

    @SerializedName("thumbnailHeight")
    @Expose
    private int thumbnailHeight;

    @SerializedName("thumbnailWidth")
    @Expose
    private int thumbnailWidth;

    @SerializedName("byteSize")
    @Expose
    private long byteSize;


    public Image(int width, int height, String contextLink, String thumbnailLink, int thumbnailHeight, int thumbnailWidth, long byteSize) {
        this.width = width;
        this.height = height;
        this.contextLink = contextLink;
        this.thumbnailLink = thumbnailLink;
        this.thumbnailHeight = thumbnailHeight;
        this.thumbnailWidth = thumbnailWidth;
        this.byteSize = byteSize;
    }

    public Image() {
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getContextLink() {
        return contextLink;
    }

    public void setContextLink(String contextLink) {
        this.contextLink = contextLink;
    }

    public String getThumbnailLink() {
        return thumbnailLink;
    }

    public void setThumbnailLink(String thumbnailLink) {
        this.thumbnailLink = thumbnailLink;
    }

    public int getThumbnailHeight() {
        return thumbnailHeight;
    }

    public void setThumbnailHeight(int thumbnailHeight) {
        this.thumbnailHeight = thumbnailHeight;
    }

    public int getThumbnailWidth() {
        return thumbnailWidth;
    }

    public void setThumbnailWidth(int thumbnailWidth) {
        this.thumbnailWidth = thumbnailWidth;
    }

    public long getByteSize() {
        return byteSize;
    }

    public void setByteSize(long byteSize) {
        this.byteSize = byteSize;
    }
}
