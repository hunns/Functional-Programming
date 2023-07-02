package com.honeybadger.functionalProgramming.combinator;

import java.time.LocalDate;

public class Customer {
    private String name;
    private String email;

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    private LocalDate DOB;
    private String phoneNumber;

    public Customer(String name, String email, LocalDate age, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.DOB = age;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
