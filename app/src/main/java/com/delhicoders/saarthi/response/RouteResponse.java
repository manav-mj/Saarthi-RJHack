package com.delhicoders.saarthi.response;

import com.delhicoders.saarthi.models.RoutePlace;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by YourFather on 20-03-2018.
 */

public class RouteResponse {
    @SerializedName("data")
    public RouteData data;

    public class RouteData {
        @SerializedName("locations")
        public ArrayList<RoutePlace> locations;
    }
}
