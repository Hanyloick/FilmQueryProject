package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private static final String USER = "student";
	private static final String PASSWORD = "student";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;

		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

			String sqlStatement = "SELECT * FROM actor WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
			preparedStatement.setInt(1, actorId);
			ResultSet actorResult = preparedStatement.executeQuery();
			// while would be more than 1
			if (actorResult.next()) {
				int id = actorResult.getInt("id");
				String firstName = actorResult.getString("first_name");
				String lastName = actorResult.getString("last_name");

				actor = new Actor(id, firstName, lastName);
			}
			actorResult.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> cast = new ArrayList<>();
		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			String sqlStaement = "SELECT actor.* FROM actor JOIN film_actor ON film_actor.actor_id = actor.id WHERE film_actor.film_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlStaement);
			preparedStatement.setInt(1, filmId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");

				Actor actor = new Actor(id, firstName, lastName);
				cast.add(actor);
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cast;

	}

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;

		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			String sqlStaement = "SELECT * FROM film WHERE film.id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlStaement);
			preparedStatement.setInt(1, filmId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String descritpion = resultSet.getString("description");
				short releaseYear = resultSet.getShort("release_year");
				int languageId = resultSet.getInt("language_id");
				int rentDur = resultSet.getInt("rental_duration");
				double rentalRate = resultSet.getDouble("rental_rate");
				int length = resultSet.getInt("length");
				double replacementCost = resultSet.getDouble("replacement_cost");
				String rating = resultSet.getString("rating");
				String specialFeatures = resultSet.getString("special_features");
				film = new Film(id, title, descritpion, releaseYear, languageId, rentDur, rentalRate, length,
						replacementCost, rating, specialFeatures);
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return film;
	}

	@Override
	public List<Film> findFilmsByActorId(int actorId) {
		List<Film> films = new ArrayList<>();
		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			String sqlStaement = "SELECT film.* FROM film JOIN film_actor ON film.id = film_actor.film_id WHERE actor_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlStaement);
			preparedStatement.setInt(1, actorId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int filmId = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String descritpion = resultSet.getString("description");
				short releaseYear = resultSet.getShort("release_year");
				int languageId = resultSet.getInt("language_id");
				int rentDur = resultSet.getInt("rental_duration");
				double rentalRate = resultSet.getDouble("rental_rate");
				int length = resultSet.getInt("length");
				double replacementCost = resultSet.getDouble("replacement_cost");
				String rating = resultSet.getString("rating");
				String specialFeatures = resultSet.getString("special_features");
				Film film = new Film(filmId, title, descritpion, releaseYear, languageId, rentDur, rentalRate, length,
						replacementCost, rating, specialFeatures);
				films.add(film);
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	@Override
	public List<Film> findFilmsByKeyword(String keyword) {
		List<Film> films = new ArrayList<>();

		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			String sqlStaement = "SELECT film.* FROM film WHERE film.title LIKE ? or film.description LIKE ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlStaement);
			preparedStatement.setString(1, "%" + keyword + "%");
			preparedStatement.setString(2, "%" + keyword + "%");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String descritpion = resultSet.getString("description");
				short releaseYear = resultSet.getShort("release_year");
				int languageId = resultSet.getInt("language_id");
				int rentDur = resultSet.getInt("rental_duration");
				double rentalRate = resultSet.getDouble("rental_rate");
				int length = resultSet.getInt("length");
				double replacementCost = resultSet.getDouble("replacement_cost");
				String rating = resultSet.getString("rating");
				String specialFeatures = resultSet.getString("special_features");
				Film film = new Film(id, title, descritpion, releaseYear, languageId, rentDur, rentalRate, length,
						replacementCost, rating, specialFeatures);
				films.add(film);

			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return films;
	}

	@Override
	public List<Film> findCopiesCondition(Film film) {
		List<Film> films = new ArrayList<>();

		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			String sqlStaement = "SELECT film.*, inventory_item.*, language.name, actor.*, category.name FROM film JOIN film_actor on film_actor.film_id = film.id JOIN actor on film_actor.actor_id = actor.id JOIN inventory_item on film.id= inventory_item.film_id JOIN film_category on film.id = film_category.film_id JOIN category on film_category.category_id = category.id JOIN language ON film.language_id = language.id WHERE film.id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlStaement);
			preparedStatement.setInt(1, film.getFilmId());
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String descritpion = resultSet.getString("description");
				short releaseYear = resultSet.getShort("release_year");
				int languageId = resultSet.getInt("language_id");
				int rentDur = resultSet.getInt("rental_duration");
				String condition = resultSet.getString("media_condition");
				double rentalRate = resultSet.getDouble("rental_rate");
				int length = resultSet.getInt("length");
				double replacementCost = resultSet.getDouble("replacement_cost");
				String rating = resultSet.getString("rating");
				String specialFeatures = resultSet.getString("special_features");
				String language = resultSet.getString("language.name");
				List<Actor> cast = findActorsByFilmId(id);
				String category = resultSet.getString("category.name");
				film = new Film(id, title, descritpion, releaseYear, languageId, rentDur, condition, rentalRate, length,
						replacementCost, rating, specialFeatures, language, cast, category);
				films.add(film);

			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return films;
	}

	public List<Film> getAllInfoOnAllCopiesFilms(String keyword) {
		List<Film> films = new ArrayList<>();

		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			String sqlStaement = "SELECT film.*, inventory_item.*, language.name, actor.*, category.name FROM film JOIN film_actor on film_actor.film_id = film.id JOIN actor on film_actor.actor_id = actor.id JOIN inventory_item on film.id = inventory_item.film_id JOIN film_category on film.id = film_category.film_id JOIN category on film_category.category_id = category.id JOIN language ON film.language_id = language.id WHERE film.title LIKE ? OR film.description LIKE ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlStaement);
			preparedStatement.setString(1, "%" + keyword + "%");
			preparedStatement.setString(2, "%" + keyword + "%");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String descritpion = resultSet.getString("description");
				short releaseYear = resultSet.getShort("release_year");
				int languageId = resultSet.getInt("language_id");
				int rentDur = resultSet.getInt("rental_duration");
				String condition = resultSet.getString("media_condition");
				double rentalRate = resultSet.getDouble("rental_rate");
				int length = resultSet.getInt("length");
				double replacementCost = resultSet.getDouble("replacement_cost");
				String rating = resultSet.getString("rating");
				String specialFeatures = resultSet.getString("special_features");
				String language = resultSet.getString("language.name");
				List<Actor> cast = findActorsByFilmId(id);
				String category = resultSet.getString("category.name");
				Film film = new Film(id, title, descritpion, releaseYear, languageId, rentDur, condition, rentalRate,
						length, replacementCost, rating, specialFeatures, language, cast, category);
				films.add(film);

			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return films;

	}

}
