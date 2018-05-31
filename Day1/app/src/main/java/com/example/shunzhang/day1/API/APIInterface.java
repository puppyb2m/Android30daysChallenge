package com.example.shunzhang.day1.API;

import com.example.shunzhang.day1.Model.MovieModel;
import com.example.shunzhang.day1.Model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by shunzhang on 30/05/2018.
 */

public interface APIInterface {
    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovie(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<MovieResponse> getMovie(@Path("id") int id, @Query("api_key") String apiKey);
}
