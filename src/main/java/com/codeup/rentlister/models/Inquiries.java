package com.codeup.rentlister.models;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "inquiries")
public class Inquiries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "tenant", referencedColumnName = "id")
    private User tenant;

    @ManyToOne
    @JoinColumn(name = "manager", referencedColumnName = "id")
    private User manager;

    @ManyToOne
    @JoinColumn(name = "property", referencedColumnName = "id")
    private Property property;

    @Column
    private String start_date;
    @Column
    private String end_date;
    @Column
    private int people;
    @Column
    private String pets;

    public Inquiries() {
    }

    public Inquiries(User tenant, User manager, Property property, String startDate, String endDate, int people, String pets) {
        this.tenant = tenant;
        this.manager = manager;
        this.property = property;
        this.start_date = startDate;
        this.end_date = endDate;
        this.people = people;
        this.pets = pets;

    }

    @Override
    public String toString() {
        return "inquiry{" +
                "tenant=" + tenant + '\'' +
                ", manager=" + manager +
                ", property=" + property +
                ", people=" + people +
                ", pets=" + pets +
                ", startDate=" + start_date +
                ", endDate='" + end_date + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getTenant() {
        return tenant;
    }

    public void setTenant(User tenant) {
        this.tenant = tenant;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public String getPets() {
        return pets;
    }

    public void setPets(String pets) {
        this.pets = pets;
    }


}