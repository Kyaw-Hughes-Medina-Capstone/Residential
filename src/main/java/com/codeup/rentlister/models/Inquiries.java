package com.codeup.rentlister.models;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "inquiries")
public class Inquiries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "tenant_id", referencedColumnName = "id", nullable = false)
    private User tenant;

    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "id", nullable = false)
    private User manager;

    @ManyToOne
    @JoinColumn(name = "property_id", referencedColumnName = "id", nullable = false)
    private Property property;

    //Nullable values
    @Column
    private Date start_date;
    @Column
    private Date end_date;
    @Column
    private int people;
    @Column
    private int pets;

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

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public int getPets() {
        return pets;
    }

    public void setPets(int pets) {
        this.pets = pets;
    }
}