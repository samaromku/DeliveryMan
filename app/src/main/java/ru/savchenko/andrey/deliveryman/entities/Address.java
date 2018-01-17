package ru.savchenko.andrey.deliveryman.entities;

/**
 * Created by savchenko on 17.01.18.
 */

public class Address {
    private int id;
    private String address;
    private double lat;
    private double lng;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public Address(int id, String address, double lat, double lng) {
        this.id = id;
        this.address = address;
        this.lat = lat;
        this.lng = lng;
    }
}
