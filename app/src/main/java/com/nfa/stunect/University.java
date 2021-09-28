package com.nfa.stunect;

public class University {

    private final String uniID;
    private String name;
    private String country;
    private String city;
    private String email_suffix;

    public University(String uniID,String name,String country,String city,String email_suffix) {
        this.uniID = uniID;
        this.name = name;
        this.country = country;
        this.city = city;
        this.email_suffix = email_suffix;

    }

    //Getters

    public String getUniID() {
        return this.uniID;
    }

    public String getName() {
        return this.name;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCity() {
        return this.city;
    }

    public String getEmail_suffix() {
        return this.email_suffix;
    }

}
