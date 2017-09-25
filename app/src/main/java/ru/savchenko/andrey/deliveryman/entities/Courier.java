package ru.savchenko.andrey.deliveryman.entities;

/**
 * Created by Andrey on 11.09.2017.
 */

public class Courier {
    private int id;
    private String name;
    private String phone;

    private Courier(Builder builder) {
        id = builder.id;
        name = builder.name;
        phone = builder.phone;
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

    public static final class Builder {
        private int id;
        private String name;
        private String phone;

        public Builder() {
        }

        public Builder id(int val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder phone(String val) {
            phone = val;
            return this;
        }

        public Courier build() {
            return new Courier(this);
        }
    }
}
