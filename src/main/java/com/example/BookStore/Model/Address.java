package com.example.BookStore.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Address {

    @NotNull
    private int house_no;

    @NotBlank
    private String street;

    @NotBlank
    private String barangay;

    @NotBlank
    private String city;

    public Address(int house_no, String street, String barangay, String city) {
        this.house_no = house_no;
        this.street = street;
        this.barangay = barangay;
        this.city = city;
    }

    public int getHouse_no() {
        return house_no;
    }

    public void setHouse_no(int house_no) {
        this.house_no = house_no;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBarangay() {
        return barangay;
    }

    public void setBarangay(String barangay) {
        this.barangay = barangay;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
