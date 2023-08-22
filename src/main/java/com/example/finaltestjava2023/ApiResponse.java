package com.example.finaltestjava2023;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ApiResponse {
    @SerializedName("Company")
    private String company;

    @SerializedName("Customers")
    private ArrayList<Customer> customers;

    public String getCompany() {
        return company;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
