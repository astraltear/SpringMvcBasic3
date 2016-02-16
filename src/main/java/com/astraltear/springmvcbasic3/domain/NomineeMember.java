package com.astraltear.springmvcbasic3.domain;

public class NomineeMember {
	private String firstName;
	private String lastName;

	public NomineeMember() { }

	public NomineeMember(String firstName, String lastName) {
	this.firstName = firstName;
	this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String toString() {
		return firstName + " " + lastName;
	}
}
