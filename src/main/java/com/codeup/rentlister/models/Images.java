//package com.codeup.rentlister.models;
//
//import jakarta.persistence.*;
//
//import java.util.Properties;
//
//@Entity
//
//@Table(name = "images")
//public class Images {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//
//
//	@ManyToOne
//	@JoinColumn(name = "property_id", referencedColumnName = "id")
//	private Property property;
//
//	@Column(nullable = false)
//	private String url;
//
//	public Images(){
//	}
//
//	public Images(Property property, String url) {
//		this.property = property;
//		this.url = url;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public Property getProperty() {
//		return property;
//	}
//
//	public void setProperty(Property property) {
//		this.property = property;
//	}
//
//	public String getUrl() {
//		return url;
//	}
//
//	public void setUrl(String url) {
//		this.url = url;
//	}
//}