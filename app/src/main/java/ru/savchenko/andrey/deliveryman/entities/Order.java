package ru.savchenko.andrey.deliveryman.entities;

import org.joda.time.DateTime;

/**
 * Created by Andrey on 09.09.2017.
 */

public class Order {
    private int id;
    private String title;
    private String body;
    private DateTime created;
    private DateTime deadLine;
    private double way;
    private int status;
    private int rating;
    private String url;

    private Order(Builder builder) {
        id = builder.id;
        title = builder.title;
        body = builder.body;
        created = builder.created;
        deadLine = builder.deadLine;
        way = builder.way;
        status = builder.status;
        rating = builder.rating;
        url = builder.url;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", created=" + created +
                ", deadLine=" + deadLine +
                ", way=" + way +
                ", status=" + status +
                ", rating=" + rating +
                ", url=" + url +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public DateTime getCreated() {
        return created;
    }

    public void setCreated(DateTime created) {
        this.created = created;
    }

    public DateTime getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(DateTime deadLine) {
        this.deadLine = deadLine;
    }

    public double getWay() {
        return way;
    }

    public void setWay(double way) {
        this.way = way;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static final class Builder {
        private int id;
        private String title;
        private String body;
        private DateTime created;
        private DateTime deadLine;
        private double way;
        private int status;
        private int rating;
        private String url;

        public Builder() {
        }

        public Builder id(int val) {
            id = val;
            return this;
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder body(String val) {
            body = val;
            return this;
        }

        public Builder created(DateTime val) {
            created = val;
            return this;
        }

        public Builder deadLine(DateTime val) {
            deadLine = val;
            return this;
        }

        public Builder way(double val) {
            way = val;
            return this;
        }

        public Builder status(int val) {
            status = val;
            return this;
        }

        public Builder rating(int val) {
            rating = val;
            return this;
        }

        public Builder url(String val) {
            url = val;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }

    public Order(int id, String title, String body, DateTime created, DateTime deadLine, double way) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.created = created;
        this.deadLine = deadLine;
        this.way = way;
    }

    public Order(int id, String title, String body, DateTime created, DateTime deadLine, double way, String url) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.created = created;
        this.deadLine = deadLine;
        this.way = way;
        this.url = url;
    }
}