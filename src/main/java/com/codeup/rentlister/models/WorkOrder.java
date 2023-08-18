package com.codeup.rentlister.models;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "workorders")
public class WorkOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "property_id", referencedColumnName = "id")
	private Property property_id;

	@OneToOne
	@JoinColumn(name = "tenant_id", referencedColumnName = "id")
	private User tenant_id;

	@Column(nullable = false)
	private int manager_id;

	@Column(nullable = false)
	private String description;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date date;

	public WorkOrder(int id, Property property_id, User tenant_id, int manager_id, String description, Date date) {
		this.id = id;
		this.property_id = property_id;
		this.tenant_id = tenant_id;
		this.manager_id = manager_id;
		this.description = description;
		this.date = date;
	}

	public WorkOrder() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Property getProperty_id() {
		return property_id;
	}

	public void setProperty_id(Property property_id) {
		this.property_id = property_id;
	}

	public User getTenant_id() {
		return tenant_id;
	}

	public void setTenant_id(User tenant_id) {
		this.tenant_id = tenant_id;
	}

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
