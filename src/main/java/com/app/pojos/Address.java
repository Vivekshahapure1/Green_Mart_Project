package com.app.pojos;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity		//to hibernate that object of product class is to be persisted into the database
@Table(name = "user_adr")		//In which table object is to be persisted
public class Address {

	@Id		//for primarykey
	@GeneratedValue(strategy = GenerationType.IDENTITY)		//autoincremented
	private Long id;
	@Column(length = 30)	//name of column in db
	private String city;
	@Column(length = 30)
	private String state;
	@Column(length = 30)
	private String country;

	// non owning side(inverse side) bi dir..
	@OneToOne(mappedBy = "adr")		//address named with adr in Users table
	@JsonIgnoreProperties("adr")
	private User user;

	public Address() {
		System.out.println("in Address cnstr");
	}

	public Address(String city, String state, String country) {
		super();
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", state=" + state + ", country=" + country + "]";
	}

}
