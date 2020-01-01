package com.example.imagesearch.network;

import com.example.imagesearch.model.ImageList;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ImageApi  {
    //?
    @GET("v1")
    Flowable<ImageList> searchImages(@Query("q") String query, @Query("key") String key, @Query("cx") String cx, @Query("searchType") String searchType);
}
