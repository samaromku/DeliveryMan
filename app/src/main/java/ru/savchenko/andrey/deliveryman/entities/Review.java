package ru.savchenko.andrey.deliveryman.entities;
import org.joda.time.DateTime;

/**
 * Created by savchenko on 12.09.17.
 */

public class Review {
    private int id;
    private String title;
    private String body;
    private DateTime dateTime;
    private int rating;
    private String userName;

    private Review(Builder builder) {
        setId(builder.id);
        setTitle(builder.title);
        setBody(builder.body);
        setDateTime(builder.dateTime);
        setRating(builder.rating);
        setUserName(builder.userName);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", dateTime=" + dateTime +
                ", rating=" + rating +
                ", userName='" + userName + '\'' +
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

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static final class Builder {
        private int id;
        private String title;
        private String body;
        private DateTime dateTime;
        private int rating;
        private String userName;

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

        public Builder dateTime(DateTime val) {
            dateTime = val;
            return this;
        }

        public Builder rating(int val) {
            rating = val;
            return this;
        }

        public Builder userName(String val) {
            userName = val;
            return this;
        }

        public Review build() {
            return new Review(this);
        }
    }
}
