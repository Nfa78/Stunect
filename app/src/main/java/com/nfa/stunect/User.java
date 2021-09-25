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
    public String getName(){return name;}
    public String getLastName(){return  lastName;}
    public int getID (){return  id;}
    public float getRating(){return  rating;}
    public float getRatingsCount(){return  ratingsCount;}
    public void setRating(float _nRating)
    {
        rating = ((rating*ratingsCount) + _nRating)
                /(ratingsCount+1);
        ratingsCount++;
    }
    public String getEmail(){return email;}
    public String getCountry(){return  Country;}
    public String getCity(){return City;}
    public String getPassword() {return password;}


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
}
