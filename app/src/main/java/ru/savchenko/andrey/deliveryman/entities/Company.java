package ru.savchenko.andrey.deliveryman.entities;

/**
 * Created by Andrey on 11.09.2017.
 */

public class Company {
    private int id;
    private String companyName;
    private String url;

    private Company(Builder builder) {
        setId(builder.id);
        setCompanyName(builder.companyName);
        setUrl(builder.url);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public static final class Builder {
        private int id;
        private String companyName;
        private String url;

        public Builder() {
        }

        public Builder id(int val) {
            id = val;
            return this;
        }

        public Builder companyName(String val) {
            companyName = val;
            return this;
        }

        public Builder url(String val) {
            url = val;
            return this;
        }

        public Company build() {
            return new Company(this);
        }
    }
}
