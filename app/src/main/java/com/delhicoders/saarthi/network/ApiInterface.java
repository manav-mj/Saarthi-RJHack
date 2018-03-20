package com.delhicoders.saarthi.network;

import com.delhicoders.saarthi.response.RouteResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by YourFather on 20-03-2018.
 */

public interface ApiInterface {
    @GET("test")
    Call<RouteResponse> getRoute(@Query("latitude") double lat, @Query("longitude") double lng);
}
