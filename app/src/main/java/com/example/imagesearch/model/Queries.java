package com.example.imagesearch.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Queries {

    @SerializedName("request")
    private List<Request> request;

    @SerializedName("nextPage")
    private List<NextPage> nextPage;

    public Queries() {
    }

    public Queries(List<Request> request, List<NextPage> nextPage) {
        this.request = request;
        this.nextPage = nextPage;
    }

    public List<Request> getRequests() {
        return request;
    }

    public void setRequests(List<Request> request) {
        this.request = request;
    }

    public List<NextPage> getNextPage() {
        return nextPage;
    }

    public void setNextPage(List<NextPage> nextPage) {
        this.nextPage = nextPage;
    }
}
