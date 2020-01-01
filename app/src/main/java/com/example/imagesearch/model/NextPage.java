package com.example.imagesearch.model;

import com.google.gson.annotations.SerializedName;

public class NextPage {

    @SerializedName("totalResults")
    private long totalResults;

    @SerializedName("searchTerms")
    private String searchTerms;

    @SerializedName("count")
    private int count;

    @SerializedName("startIndex")
    private long startIndex;

    @SerializedName("searchType")
    private String searchType;

    public NextPage() {
    }

    public NextPage(long totalResults, String searchTerms, int count, long startIndex, String searchType) {
        this.totalResults = totalResults;
        this.searchTerms = searchTerms;
        this.count = count;
        this.startIndex = startIndex;
        this.searchType = searchType;
    }

    public long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(long totalResults) {
        this.totalResults = totalResults;
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

    public long getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(long startIndex) {
        this.startIndex = startIndex;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }
}
