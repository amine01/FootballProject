package com.essamine.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {
	@Id
	@GeneratedValue
	private long id;
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private Date dob;
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	private List<Nationality> nationalities = new ArrayList<Nationality>();

	public Person() {
	}

	
	public Person(String firstname, String lastname, Date dob) {
	
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
	}


	public Person(long id, String firstname, String lastname, Date dob) {

		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.setDob(dob);

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public List<Nationality> getNationalities() {
		return nationalities;
	}

	public void setNationalities(List<Nationality> nationalities) {
		this.nationalities = nationalities;
	}

}
