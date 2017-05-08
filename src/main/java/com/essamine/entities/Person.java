package com.essamine.entities;

import java.util.Date;

public class Person {

	private long id;
	private String firstname;
	private String lastname;
	private Date dob;
	private long[] listNationalities;

	public Person() {
	}

	public Person(long id, String firstname, String lastname, Date dob,
			long[] listNationalities) {

		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.listNationalities = listNationalities;
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

	public long[] getListNationalities() {
		return listNationalities;
	}

	public void setListNationalities(long[] listNationalities) {
		this.listNationalities = listNationalities;
	}
}
