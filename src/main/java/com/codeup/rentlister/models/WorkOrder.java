package com.codeup.rentlister.models;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "workorders")
public class WorkOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "tenant", referencedColumnName = "id", nullable = false)
    private User tenant;

    @ManyToOne
    @JoinColumn(name = "manager", referencedColumnName = "id", nullable = false)
    private User manager;

    @ManyToOne
    @JoinColumn(name = "property", referencedColumnName = "id", nullable = false)
    private Property property;

    @Column(nullable = false)
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private String date;

    public WorkOrder() {
    }

    public WorkOrder(User tenant, User manager, Property property, String description, String date) {
        this.property = property;
        this.tenant = tenant;
        this.manager = manager;
        this.description = description;
        this.date = date;
    }

    @Override
    public String toString() {
        return "WorkOrder{" +
                "tenant=" + tenant + '\'' +
                ", manager=" + manager +
                ", property=" + property +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property= property;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}