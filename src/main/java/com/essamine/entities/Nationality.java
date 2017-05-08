package com.essamine.entities;

public class Nationality {
	private long id;
	private String nationality;
	private long person_id;

	public Nationality(long id, String nationality,long person_id) {

		this.id = id;
		this.nationality = nationality;
		this.person_id=person_id;
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

	public long getPerson_id() {
		return person_id;
	}

	public void setPerson_id(long person_id) {
		this.person_id = person_id;
	}
	
	

}
