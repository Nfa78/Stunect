package com.nfa.stunect;

public class User {
    private String name;
    private String lastName;
    private int id;
    private String Country,City;
    private float rating;
    private int ratingsCount;
    private String password;
    private String email;

    public User (int id,String name,String last,String email,String password,String Country,String city){
      this.id = id;
      this.name = name;
      this.lastName = last;
      this.Country = Country;
      this.City = city;
      this.password = password;
      this.email = email;
    }

    public User (int id,String name,String last,String email,String password){
        this.id = id;
        this.name = name;
        this.lastName = last;
        this.password = password;
        this.email = email;
    }

    //Getters

    public String getName() {
        return this.name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getID () {
        return this.id;
    }

    public float getRating() {
        return this.rating;
    }

    public float getRatingsCount() {
        return this.ratingsCount;
    }

    public String getEmail() {
        return this.email;
    }

    public String getCountry() {
        return this.Country;
    }

    public String getCity() {
        return this.City;
    }

    public String getPassword() {
        return this.password;
    }

    //Setters

    public void setRating(float _nRating)
    {
        rating = ((rating*ratingsCount) + _nRating)
                /(ratingsCount+1);
        ratingsCount++;
    }




}
