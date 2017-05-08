package com.essamine.entities;

public class Nationality {
	private long id;
	private String nationality;

	public Nationality(long id, String nationality) {

		this.id = id;
		this.nationality = nationality;
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

}
