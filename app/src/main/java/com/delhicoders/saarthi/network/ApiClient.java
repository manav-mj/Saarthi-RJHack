package com.delhicoders.saarthi.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by prachi on 14/1/18.
 */

public class ApiClient {
    static private ApiInterface apiInterface;

    public static ApiInterface getApiInterface(){
        if(apiInterface ==null){

            Retrofit retrofit= new Retrofit.Builder().baseUrl("https://7ba624ea.ngrok.io/api/v1/")
                    .addConverterFactory(GsonConverterFactory.create()).build();
            apiInterface =retrofit.create(ApiInterface.class);
        }
        return apiInterface;
    }
}
