package com.example.BookStore.Model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name="customers")
public class Customer extends User {

    @Id
    @GeneratedValue
    private Long customer_id;

    @NotBlank(message = "First name cannot be blank")
    private String fname;

    @NotBlank(message = "Last name cannot be blank")
    private String lname;

    @NotNull(message = "Phone is required")
    private String phone;

    @Embedded
    @Valid
    private Address address;

    @Min(value= 13, message = "Users aged 13 years and older can create an account.")
    private int age;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public Customer(){}

    public Customer(String username, String email, String password){
                super(username,email,password);
    }

    public Customer(String fname, String lname, String phone, Address address, int age, String username, String email, String password) {
        super(username, email,password);
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.address = address;
        this.age = age;
        //initilize created and updated to date now when created
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}
