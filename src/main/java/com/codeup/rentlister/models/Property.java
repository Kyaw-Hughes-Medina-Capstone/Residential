package com.codeup.rentlister.models;

import jakarta.persistence.*;

import java.math.BigDecimal;


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

	@Column
	private int area;

	@Column
	private int beds;

	@Column
	private int bath;

	@Column(nullable = false)
	private String img1;

	@Column(nullable = false)
	private String img2;

	@Column(nullable = false)
	private String img3;

	@Column(nullable = false)
	private String img4;

	@Column(nullable = false)
	private String address;

	@Column(nullable = false)
	private String city;

	@Column(nullable = false)
	private String state;

	@Column(nullable = false)
	private int zip;

	@Column(nullable = false, precision = 8, scale = 6)
	private BigDecimal latitude;

	@Column(nullable = false, precision = 8, scale = 6)
	private BigDecimal longitude;

	@Override
	public String toString() {
		return "Property{" +
				"id=" + id +
				", type='" + type + '\'' +
				", rent=" + rent +
				", area=" + area +
				", beds=" + beds +
				", bath=" + bath +
				", img1='" + img1 + '\'' +
				", img2='" + img2 + '\'' +
				", img3='" + img3 + '\'' +
				", img4='" + img4 + '\'' +
				", address='" + address + '\'' +
				", city='" + city + '\'' +
				", state='" + state + '\'' +
				", zip=" + zip +
				", pets=" + pets +
				", description='" + description + '\'' +
				'}';
	}

	@Column
	private boolean pets;

	@Column(nullable = false, columnDefinition = "MEDIUMTEXT")
	private String description;


	public Property(int id, String type, int rent, int area, int beds, int bath, String img1, String img2, String img3, String img4, String address, String city, String state, int zip, boolean pets, String description) {
		this.id = id;
		this.type = type;
		this.rent = rent;
		this.area = area;
		this.beds = beds;
		this.bath = bath;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.pets = pets;
		this.description = description;
	}

	public Property() {

	}

	public Property(String type, float rent, int area, int beds, int bath, String img1, String img2, String img3, String img4, String address, String city, String state, int zip, String pets, String description) {
	}

	public Property(String type, float rent, int area, int beds, int bath, String img1, String img2, String img3, String img4, String city, String state, int zip, String pets, String description) {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
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

	public String getImg1() {
		return img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg2() {
		return img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public String getImg3() {
		return img3;
	}

	public void setImg3(String img3) {
		this.img3 = img3;
	}

	public String getImg4() {
		return img4;
	}

	public void setImg4(String img4) {
		this.img4 = img4;
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

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public boolean isPets() {
		return pets;
	}

	public void setPets(boolean pets) {
		this.pets = pets;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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