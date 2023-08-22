package com.example.finaltestjava2023;

import com.google.gson.annotations.SerializedName;

public class Customer {
    private String id;
    private String email;

    @SerializedName("first")
    private String firstName;
    @SerializedName("last")
    private String lastName;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getCountry() {
        return country;
    }

    private String company;
    private String created_at ;
    private String country ;

}
