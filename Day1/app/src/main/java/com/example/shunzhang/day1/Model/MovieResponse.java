package com.example.shunzhang.day1.Model;

/**
 * Created by shunzhang on 30/05/2018.
 */

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class MovieResponse {
    @SerializedName("page")
    private int page;
    @SerializedName("results")
    private List<MovieModel> results;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<MovieModel> getResults() {
        return results;
    }

    public void setResults(List<MovieModel> results) {
        this.results = results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}