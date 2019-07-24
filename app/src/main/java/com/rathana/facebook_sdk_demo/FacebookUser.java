package com.rathana.facebook_sdk_demo;

public class FacebookUser {

    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("verified")
    private boolean verified;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("updated_time")
    private String updatedTime;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("timezone")
    private int timezone;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("name")
    private String name;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("locale")
    private String locale;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("location")
    private LocationEntity location;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("link")
    private String link;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("last_name")
    private String lastName;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("gender")
    private String gender;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("first_name")
    private String firstName;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("birthday")
    private String birthday;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("id")
    private String id;

    private String profile;

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public boolean getVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public LocationEntity getLocation() {
        return location;
    }

    public void setLocation(LocationEntity location) {
        this.location = location;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static class LocationEntity {
        @com.google.gson.annotations.Expose
        @com.google.gson.annotations.SerializedName("name")
        private String name;
        @com.google.gson.annotations.Expose
        @com.google.gson.annotations.SerializedName("id")
        private String id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "LocationEntity{" +
                    "name='" + name + '\'' +
                    ", id='" + id + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "FacebookUser{" +
                "verified=" + verified +
                ", updatedTime='" + updatedTime + '\'' +
                ", timezone=" + timezone +
                ", name='" + name + '\'' +
                ", locale='" + locale + '\'' +
                ", location=" + location +
                ", link='" + link + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", id='" + id + '\'' +
                ", profile='" + profile + '\'' +
                '}';
    }
}
