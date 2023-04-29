package com.skilldistillery.filmquery.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Film {
	private int filmId;
	private String title;
	private String description;
	private short releaseYear;
	private int langId;
	private int rentalDuration;
//	private String condition;
	private double rate;
	private int length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	private List<Actor> cast;
	private String language;

	public Film() {

	}

	public Film(int filmId, String title, String desc, short releaseYear, int langId, int rentDur, double rate,
			int length, double repCost, String rating, String features) {
		this.filmId = filmId;
		this.title = title;
		this.description = desc;
		this.releaseYear = releaseYear;
		this.langId = langId;
		this.rentalDuration = rentDur;
		this.rate = rate;
		this.length = length;
		this.replacementCost = repCost;
		this.rating = rating;
		this.specialFeatures = features;
	}
	
	
//	
//	public Film(int filmId, String title, String description, short releaseYear, int langId, int rentalDuration,
//			String condition, double rate, int length, double replacementCost, String rating, String specialFeatures) {
//		super();
//		this.filmId = filmId;
//		this.title = title;
//		this.description = description;
//		this.releaseYear = releaseYear;
//		this.langId = langId;
//		this.rentalDuration = rentalDuration;
//		this.condition = condition;
//		this.rate = rate;
//		this.length = length;
//		this.replacementCost = replacementCost;
//		this.rating = rating;
//		this.specialFeatures = specialFeatures;
//	}
	
	

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public short getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(short releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLangId() {
		return langId;
	}

	public void setLangId(int langId) {
		this.langId = langId;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		
		this.rate = rate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public List<Actor> getCast() {
		return cast;
	}

	public void setCast(List<Actor> cast) {
		this.cast = cast;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cast, description, specialFeatures, filmId, langId, length, rate, rating, releaseYear,
				rentalDuration, replacementCost, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(cast, other.cast) && Objects.equals(description, other.description)
				&& Objects.equals(specialFeatures, other.specialFeatures) && filmId == other.filmId
				&& langId == other.langId && length == other.length
				&& Double.doubleToLongBits(rate) == Double.doubleToLongBits(other.rate)
				&& Objects.equals(rating, other.rating) && releaseYear == other.releaseYear
				&& rentalDuration == other.rentalDuration
				&& Double.doubleToLongBits(replacementCost) == Double.doubleToLongBits(other.replacementCost)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Film [filmId=");
		builder.append(filmId);
		builder.append(", ");
		if (title != null) {
			builder.append("title=");
			builder.append(title);
			builder.append(", ");
		}
		if (description != null) {
			builder.append("desc=");
			builder.append(description);
			builder.append(", ");
		}
		builder.append("releaseYear=");
		builder.append(releaseYear);
		builder.append(", langId=");
		builder.append(langId);
		builder.append(", rentDur=");
		builder.append(rentalDuration);
		builder.append(", rate=");
		builder.append(rate);
		builder.append(", length=");
		builder.append(length);
		builder.append(", repCost=");
		builder.append(replacementCost);
		builder.append(", ");
		if (rating != null) {
			builder.append("rating=");
			builder.append(rating);
			builder.append(", ");
		}
		if (specialFeatures != null) {
			builder.append("features=");
			builder.append(specialFeatures);
			builder.append(", ");
		}
		if (cast != null) {
			builder.append("cast=");
			builder.append(cast);
		}
		builder.append("]");
		return builder.toString();
	}

}
