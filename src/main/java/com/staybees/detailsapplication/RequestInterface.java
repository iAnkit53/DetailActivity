package com.staybees.detailsapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {
    @GET("api/apt")
    Call<List<DetailModel>> getDetailJson();
}
