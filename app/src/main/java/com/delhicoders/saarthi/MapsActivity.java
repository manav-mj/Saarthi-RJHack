package com.delhicoders.saarthi;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.delhicoders.saarthi.dummy.DummyContent;
import com.delhicoders.saarthi.models.RoutePlace;
import com.delhicoders.saarthi.network.ApiClient;
import com.delhicoders.saarthi.response.RouteResponse;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final String TAG = MapsActivity.class.getSimpleName();
    private GoogleMap mMap;
    private ArrayList<RoutePlace> places = new ArrayList<>();

    private LatLng userLatLng;
    private PlaceSelectionFragment routePlaceFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        userLatLng = getIntent().getParcelableExtra(MainActivity.LOCATION_TRANSFER_KEY);
//        getPlacesFromNetwork();
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        routePlaceFragment = (PlaceSelectionFragment) getSupportFragmentManager()
                .findFragmentById(R.id.place_list_fragment);
        mapFragment.getMapAsync(this);
        // setting dummy data
        places = DummyContent.getDummyPlaces();
        routePlaceFragment.setPlaces(places);
    }

    private void getPlacesFromNetwork() {
        ApiClient.getApiInterface().getRoute(userLatLng.latitude, userLatLng.longitude).enqueue(new Callback<RouteResponse>() {
            @Override
            public void onResponse(Call<RouteResponse> call, Response<RouteResponse> response) {
                if (response.isSuccessful()) {
                    places.addAll(response.body().data.locations);
                    addMarkers();
                    routePlaceFragment.setPlaces(places);
                }
            }

            @Override
            public void onFailure(Call<RouteResponse> call, Throwable t) {
                Log.e(TAG, "Retrofit failure fetching route", t);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        addMarkers();
    }

    private void addMarkers() {
        if (mMap != null && places.size() > 0) {
            for (int i = 0; i < places.size(); i++) {
                mMap.addMarker(new MarkerOptions().position(places.get(i).getLatLng()).title((i + 1) + ". " + places.get(i).name));
            }

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(places.get(0).getLatLng(), 15.0f));
        }
    }
}
