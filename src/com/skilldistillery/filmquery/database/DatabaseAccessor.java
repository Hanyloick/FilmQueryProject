package com.skilldistillery.filmquery.database;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public interface DatabaseAccessor {
	Film findFilmById(int filmId);

	List<Film> findFilmsByActorId(int actorId);

	List<Film> findFilmsByKeyword(String keyword);

	List<Film> findFilmsCopiesByKeyword(String keyword);
	
	List<Film> findCopiesCondition(Film film);
	
	Actor findActorById(int actorId);

	List<Actor> findActorsByFilmId(int filmId);

	String findLanguageCodeTraslation(Film film);

	String findCategorybyFilmCode(Film film);




	
	

}
