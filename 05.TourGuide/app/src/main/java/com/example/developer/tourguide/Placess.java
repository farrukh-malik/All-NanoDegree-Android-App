package com.example.developer.tourguide;

/**
 * Created by Developer on 9/7/2016.
 */
public class Placess {
    String PlaceName;
    String Details;
    String location;
    int imageid;

    public Placess(String placeName, String details, String location, int imageid) {
        PlaceName = placeName;
        Details = details;
        this.location = location;
        this.imageid = imageid;
    }

    public void setPlaceName(String placeName) {
        PlaceName = placeName;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public String getPlaceName() {
        return PlaceName;
    }

    public String getDetails() {
        return Details;
    }

    public String getLocation() {
        return location;
    }

    public int getImageid() {
        return imageid;
    }
}
