package ru.savchenko.andrey.deliveryman.entities;

/**
 * Created by Andrey on 11.09.2017.
 */

public class Courier {
    private int id;
    private String name;
    private String phone;
    private int status;

    public Courier(int id, String name, String phone, int status) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
