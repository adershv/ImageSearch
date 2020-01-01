package com.example.imagesearch.model;

import com.google.gson.annotations.SerializedName;

public class Request {

    @SerializedName("totalResults")
    private long totalResults;

    @SerializedName("searchTerms")
    private String searchTerms;

    @SerializedName("count")
    private int count;

    @SerializedName("startIndex")
    private int startIndex;

    @SerializedName("searchType")
    private String searchType;

    public Request() {
    }

    public Request(long totalResults, String searchTerms, int count, int startIndex, String searchType) {
        this.totalResults = totalResults;
        this.searchTerms = searchTerms;
        this.count = count;
        this.startIndex = startIndex;
        this.searchType = searchType;
    }

    public long getTotalResult() {
        return totalResults;
    }

    public void setTotalResult(long totalResult) {
        this.totalResults = totalResult;
    }

    public String getSearchTerms() {
        return searchTerms;
    }

    public void setSearchTerms(String searchTerms) {
        this.searchTerms = searchTerms;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }
}
