package com.example.student.hsarpartner;

/**
 * Created by Student on 7/10/2017.
 */

public class RegisterModel {
    String title,username,address,phone,aadhar,scope;

    public RegisterModel() {
    }

    public RegisterModel(String aadhar, String address, String phone, String scope, String title, String username) {
        this.aadhar = aadhar;
        this.address = address;
        this.phone = phone;
        this.scope = scope;
        this.title = title;
        this.username = username;
    }

    public String getAadhar() {
        return aadhar;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getScope() {
        return scope;
    }

    public String getTitle() {
        return title;
    }

    public String getUsername() {
        return username;
    }
}
