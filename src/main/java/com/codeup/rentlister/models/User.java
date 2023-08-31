package com.codeup.rentlister.models;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private boolean is_mgr;

	@Column(nullable = false)
	private boolean is_ctr;

	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false, unique = true)
	private String number;

	@Column
	private int zip;

	@Column
	private int people;

	@Column
	private int pets;

	@Column
	private int salary;

	public User(User copy) {
		id = copy.id;
		email = copy.email;
		username = copy.username;
		password = copy.password;
		name = copy.name;
		number = copy.number;
	}

	public User(String email, String username, String password, String name, String number) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.name = name;
		this.number = number;

	}

	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isIs_mgr() {
		return is_mgr;
	}

	public void setIs_mgr(boolean is_mgr) {
		this.is_mgr = is_mgr;
	}

	public boolean isIs_ctr() {
		return is_ctr;
	}

	public void setIs_ctr(boolean is_ctr) {
		this.is_ctr = is_ctr;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}
