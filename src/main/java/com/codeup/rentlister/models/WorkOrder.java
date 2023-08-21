package com.codeup.rentlister.models;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "workorders")
public class WorkOrder{
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

	@Column
	private String description;
	@Column
	private Date date;


	public WorkOrder(User tenant, User manager, Property property, String description, Date date){
		this.tenant = tenant;
		this.manager = manager;
		this.property = property;
		this.date = date;
		this.description = description;
	}

	public WorkOrder() {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
