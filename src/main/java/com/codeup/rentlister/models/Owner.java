package com.codeup.rentlister.models;


import jakarta.persistence.*;


@Entity
@Table(name = "Owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;
    private int bath;
    private int beds;
    private String city;
    private double latitude;
    private double longitude;
    private String pets;
    private int rent;
    private String state;
    private String type;
    private int year;
    private int zip;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "is_mgr")
    private User manager;


    public void Property() {}

    public void Property(String address, int bath, int beds, String city, double latitude, double longitude,
                         String pets, int rent, String state, String type, int year, int zip) {
        this.address = address;
        this.bath = bath;
        this.beds = beds;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.pets = pets;
        this.rent = rent;
        this.state = state;
        this.type = type;
        this.year = year;
        this.zip = zip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBath() {
        return bath;
    }

    public void setBath(int bath) {
        this.bath = bath;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getPets() {
        return pets;
    }

    public void setPets(String pets) {
        this.pets = pets;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent= rent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state= state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type= type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year= year;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip= zip;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager= manager;
    }

}
