package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	private DatabaseAccessor databaseAccessor = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		app.test();
//    app.launch();
	}

	private void test() {
		Film film = databaseAccessor.findFilmById(27);
		if (film != null) {
			System.out.println(film);
		} else {
			System.out.println("no film found");
		}

		Actor actor = databaseAccessor.findActorById(143);
		if (actor != null) {
			System.out.println(actor);
		} else {
			System.out.println("no actor found");
		}
		
		List<Actor> cast = databaseAccessor.findActorsByFilmId(10);
		System.out.println(cast);
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {

	}

}
