package com.essamine.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Nationality {
	@Id
	@GeneratedValue
	private long id;
	@Column
	private String nationality;
	@ManyToOne
	private Person person;

	public Nationality(long id, String nationality, Person person) {

		this.id = id;
		this.nationality = nationality;
		this.person = person;
	}

	

	public Nationality(String nationality, Person person) {
		this.nationality = nationality;
		this.person = person;
	}
	public Nationality() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
