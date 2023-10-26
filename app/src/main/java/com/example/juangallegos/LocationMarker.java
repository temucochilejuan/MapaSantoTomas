package com.example.juangallegos;



import com.google.android.gms.maps.model.LatLng;

public class LocationMarker {

    private LatLng location;
    private String title;

    public LocationMarker(LatLng location, String title) {
        this.location = location;
        this.title = title;
    }

    public LatLng getLocation() {
        return location;
    }

    public String getTitle() {
        return title;
    }
}
