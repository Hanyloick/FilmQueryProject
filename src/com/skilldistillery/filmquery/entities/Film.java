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
	private String condition;
	private double rate;
	private int length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	private String language;
	private List<Actor> cast;
	private String category;

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

	public Film(int filmId, String title, String description, short releaseYear, int langId, int rentalDuration,
			String condition, double rate, int length, double replacementCost, String rating, String specialFeatures) {
		super();
		this.filmId = filmId;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.langId = langId;
		this.rentalDuration = rentalDuration;
		this.condition = condition;
		this.rate = rate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
	}

	

	public Film(int filmId, String title, String description, short releaseYear, int langId, int rentalDuration,
			String condition, double rate, int length, double replacementCost, String rating, String specialFeatures,
			String language, List<Actor> cast, String category) {
		this.filmId = filmId;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.langId = langId;
		this.rentalDuration = rentalDuration;
		this.condition = condition;
		this.rate = rate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.language = language;
		this.cast = cast;
		this.category = category;
	}

	public Film(int id, String title, String description, short releaseYear, int languageId, int rentalDuration,
			double rate, int length, double replacementCost, String rating, String specialFeatures,
			String language, List<Actor> cast, String category) {
		this.filmId = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.langId = languageId;
		this.rentalDuration = rentalDuration;
		this.rate = rate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.language = language;
		this.cast = cast;
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getFilmId() {
		int id = filmId;
		return id;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getTitle() {
		String titleCopy = title;
		return titleCopy;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		String descriptionCopy = description;
		return descriptionCopy;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public short getReleaseYear() {
		short releaseYearCopy = releaseYear;
		return releaseYearCopy;
	}

	public void setReleaseYear(short releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLangId() {
		int langIdCopy = langId;
		return langIdCopy;
	}

	public void setLangId(int langId) {
		this.langId = langId;
	}

	public int getRentalDuration() {
		int rentalDurationCopy = rentalDuration;
		return rentalDurationCopy;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public String getCondition() {
		String conditionCopy = condition;
		return conditionCopy;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public double getRate() {
		double rateCopy = rate;
		return rateCopy;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getLength() {
		int lengthCopy = length;
		return lengthCopy;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacementCost() {
		double replacementCostCopy = replacementCost;
		return replacementCostCopy;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		String ratingCopy = rating;
		return ratingCopy;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		String specialFeaturesCopy = specialFeatures;
		return specialFeaturesCopy;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public List<Actor> getCast() {
		List<Actor> castCopy = cast;
		return castCopy;
	}

	public void setCast(List<Actor> cast) {
		this.cast = cast;
	}

	public String getLanguage() {
		String languageCopy = language;
		return languageCopy;
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
