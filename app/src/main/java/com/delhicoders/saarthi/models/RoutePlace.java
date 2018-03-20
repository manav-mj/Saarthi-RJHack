package com.delhicoders.saarthi.models;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by YourFather on 20-03-2018.
 */

public class RoutePlace {
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("latitude")
    @Expose
    public Double latitude;
    @SerializedName("longitude")
    @Expose
    public Double longitude;
    @SerializedName("description")
    @Expose
    public Object description;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("distance")
    @Expose
    public double distance;
    @SerializedName("duration")
    @Expose
    public Duration duration;

    public class Duration {

        @SerializedName("text")
        @Expose
        public String text;
        @SerializedName("value")
        @Expose
        public Integer value;

    }

    public LatLng getLatLng(){
        return new LatLng(latitude, longitude);
    }
}
