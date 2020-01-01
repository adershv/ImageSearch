package com.example.imagesearch.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ImageList {

    @SerializedName("queries")
    private Queries queries;

    @SerializedName("items")
    private List<Items> items;

    private int error = 0;


    public ImageList() {
    }

    public Queries getQueries() {
        return queries;
    }

    public ImageList(Queries queries, List<Items> items) {
        this.queries = queries;
        this.items = items;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public void setQueries(Queries queries) {
        this.queries = queries;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}
