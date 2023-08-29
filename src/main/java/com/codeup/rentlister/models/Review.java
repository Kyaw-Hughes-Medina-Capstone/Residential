package com.codeup.rentlister.models;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "tenant_id", referencedColumnName = "id", nullable = false)
	private User tenant;

	@ManyToOne
	@JoinColumn(name = "property_id", referencedColumnName = "id", nullable = false)
	private Property property;

	@Column(name = "rating", nullable = false)
	private int rating;

	@Column(name = "description")
	private String description;

	public Review(){
	}

	public Review(User tenant, Property property, int rating, String description) {
		this.tenant = tenant;
		this.property = property;
		this.rating = rating;
		this.description = description;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
