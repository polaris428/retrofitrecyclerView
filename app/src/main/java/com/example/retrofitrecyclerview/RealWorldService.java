package com.example.retrofitrecyclerview;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RealWorldService {
    @GET("/api/articles")
    Call<Articles> getArticle();
}
