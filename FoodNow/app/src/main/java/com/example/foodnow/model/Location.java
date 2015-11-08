package com.example.foodnow.model;

public class Location {
    private String street;
    private String city;
    private String state;
    private String zip;
    private float latitude;
    private float longitude;

    public Location(String street, String city, String state, String zip, float latitude, float longitude) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getStreet() {
        return street;
    }

    public String getZip() {
        return zip;
    }
}
