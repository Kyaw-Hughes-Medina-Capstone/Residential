package com.codeup.rentlister.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "property")
public class Property {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "manager_id", referencedColumnName = "id")
	private User manager;

	@OneToOne
	@JoinColumn(name = "tenant_id", referencedColumnName = "id")
	private User tenant;

	@Column(nullable = false)
	private String type;

	@Column
	private int rent;

	@Column(nullable = false)
	private int zip;

	@Column(nullable = false)
	private String address;

	@Column(nullable = false)
	private String city;

	@Column(nullable = false)
	private String state;

	@Column
	private int beds;

	@Column
	private int bath;

	@Column(nullable = false)
	private String pets;

	@Column(nullable = false)
	private int year;

	@Column(nullable = false, precision = 8, scale = 6)
	private BigDecimal latitude;

	@Column(nullable = false, precision = 8, scale = 6)
	private BigDecimal longitude;

	public Property() {
	}

	public Property(User manager, String type, int rent, int zip, String address, String city, String state, int beds, int bath, String pets, int year, BigDecimal latitude, BigDecimal longitude) {
		this.manager = manager;
		this.type = type;
		this.rent = rent;
		this.zip = zip;
		this.address = address;
		this.city = city;
		this.state = state;
		this.beds = beds;
		this.bath = bath;
		this.pets = pets;
		this.year = year;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	public User getTenant() {
		return tenant;
	}

	public void setTenant(User tenant) {
		this.tenant = tenant;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getBeds() {
		return beds;
	}

	public void setBeds(int beds) {
		this.beds = beds;
	}

	public int getBath() {
		return bath;
	}

	public void setBath(int bath) {
		this.bath = bath;
	}

	public String getPets() {
		return pets;
	}

	public void setPets(String pets) {
		this.pets = pets;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
}
