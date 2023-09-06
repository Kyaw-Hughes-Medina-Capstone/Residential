package com.codeup.rentlister.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Entity
@Table(name = "property")
public class Property {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

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


	@Column(name = "img1", nullable = false)
	private String img1;

	@Column(name = "img2", nullable = false)
	private String img2;

	@Column(name = "img3", nullable = false)
	private String img3;

	@Column(name = "img4", nullable = false)
	private String img4;

	@Column(nullable = false)
	private String address;

	@Column(nullable = false)
	private String city;

	@Column(nullable = false)
	private String state;

	@Column(nullable = false)
	private int zip;
	@Column
	private boolean pets;

	@Column(nullable = false, columnDefinition = "MEDIUMTEXT")
	private String description;
	@CreationTimestamp
	private LocalDateTime createdOn;
	@UpdateTimestamp
	private LocalDateTime updatedOn;
	@ManyToOne
	@JoinColumn(name = "manager", referencedColumnName = "id")
	private User manager;
	@OneToOne
	@JoinColumn(name = "tenant", referencedColumnName = "id")
	private User tenant;

	public Property(String type, int rent, int area, int beds, int bath, String img1, String img2, String img3, String img4, String address, String city, String state, int zip, boolean pets, String description, LocalDateTime createdOn, LocalDateTime updatedOn) {
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
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

	public Property(long id, String type, int rent, int area, int beds, int bath, String img1, String img2, String img3, String img4, String address, String city, String state, int zip, boolean pets, String description, LocalDateTime createdOn, LocalDateTime updatedOn) {
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
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}
	public Property(){

	}



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
				", createdOn=" + createdOn +
				", updatedOn=" + updatedOn +
				", manager=" + manager +
				", tenant=" + tenant +
				'}';
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
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

	public User setTenant(User tenant) {
		this.tenant = tenant;
		return tenant;
	}
}