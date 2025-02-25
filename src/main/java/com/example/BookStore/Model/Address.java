package com.example.BookStore.Model;

public class Address {
    private int house_no;
    private String street;
    private String barangay;
    private String city;

    public Address(String city, String barangay, String street, int house_no) {
        this.city = city;
        this.barangay = barangay;
        this.street = street;
        this.house_no = house_no;
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
