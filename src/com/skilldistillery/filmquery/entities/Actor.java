package com.skilldistillery.filmquery.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Actor {
	private int id;
	private String firstName;
	private String lastName;
	private List<Film> films;
	

	
	public List<Film> getFilm() {
		List<Film> copy = new ArrayList<Film>(films);
		return copy;
	}

	public void setFilm(List<Film> films) {
		this.films = films;
	}

	public Actor() {}

	public Actor(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Actor(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		return Objects.equals(firstName, other.firstName) && id == other.id && Objects.equals(lastName, other.lastName);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[id=");
		builder.append(id);
		builder.append(" | ");
		if (firstName != null) {
			builder.append("firstName=");
			builder.append(firstName);
			builder.append(" | ");
		}
		if (lastName != null) {
			builder.append("lastName=");
			builder.append(lastName + "]");
		}
		builder.append(" ");
		return builder.toString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	
}
