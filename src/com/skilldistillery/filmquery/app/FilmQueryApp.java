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
//		app.test();
		app.launch();
	}

	private void launch() {
		Scanner scanner = new Scanner(System.in);
		
		startUserInterface(scanner);
		scanner.close();
	}

	private void startUserInterface(Scanner scanner) {
		boolean on = true;
		int inputRangeStart = 1, inputRangeEnd = 3;
		do {
			displayMenu();
			int input = getValidInput(scanner, inputRangeStart, inputRangeEnd);
			switch (input) {
			case 1:
				findFilmById(scanner);
				break;
			case 2:
				List<Film> searchResults = findFilmBySearch(scanner);
				int rangeStart = 1, rangeEnd=2;
				if(!searchResults.isEmpty()) {
					System.out.println("would you like to view all details of this/these film(s)? 1(Yes) or 2(No)");
					if(getValidInput(scanner, inputRangeStart, inputRangeEnd) == 1) {
					displayFilmDetails(searchResults);
					}
				} else if (searchResults.isEmpty()) {
					System.out.println("There Were No Results");
				}
				break;
			case 3:
				on = false;
				System.out.println("goodbye");
				System.exit(0);
			}
		} while (on);

	}

	public void findFilmById(Scanner scanner) {
		System.out.println("Enter The Id Of The Film You're Searching For ");
		int selection = getIntInput(scanner);
		Film film = databaseAccessor.findFilmById(selection);

		if (film != null) {
			System.out.println(film.getTitle() + " " + film.getReleaseYear() + " " + film.getRating());
			System.out.println(film.getDescription()); 
			System.out.println(film.getCast());
		} else {
			System.out.println("Invalid Request, Try Again.");
		}
	}

	public List<Film> findFilmBySearch(Scanner scanner) {
		System.out.println("What Would You Like to Search?");
		
		String searchStatement = scanner.nextLine();
		
		List<Film> films = databaseAccessor.findFilmsByKeyword(searchStatement);
		
		if (!films.isEmpty()) {			
			for (Film film : films) {
				System.out.println("Title : " + film.getTitle());
				System.out.println(" ");
			}
		
		}
		return films;
		
	}

	public void displayFilmDetails(List<Film> films) {
		for (Film film: films) {
		System.out.println("Title : " + film.getTitle()); 
		System.out.println("Year : " + film.getReleaseYear());
		System.out.println("Rating : " + film.getRating());
		System.out.println("Description : " + film.getDescription());		
		System.out.println("Language : "+ databaseAccessor.findLanguageCodeTraslation(film));
		System.out.println("Cast = "+ databaseAccessor.findActorsByFilmId(film.getFilmId()));
		System.out.println(" ");
		}
	}

	private int getValidInput(Scanner scanner, int rangeStart, int rangeEnd) {
		// check for an int of one || 2
		int input = 0;
		do {
			input = getIntInput(scanner);
			if (input < rangeStart || input > rangeEnd) {
				System.out.println("Out of Range, Try Again.");
			}
		} while (input < rangeStart || input > rangeEnd);
		return input;
	}

	private int getIntInput(Scanner scanner) {
		// check for int input
		int input = 0;
		try {
			input = scanner.nextInt();
			scanner.nextLine();
		} catch (Exception e) {
			System.err.println("invalid option");
			scanner.next();
		}
		return input;
	}

	private void displayMenu() {
		System.out.println(" ");
		System.out.println("1.Look up a film by its id.");
		System.out.println("-------------------------------------");
		System.out.println("2.Look up a film by a search keyword.");
		System.out.println("-------------------------------------");
		System.out.println("3.Exit the application.");
		System.out.println(" ");
	}

//	private void test() {
//		Film film = databaseAccessor.findFilmById(27);
//		if (film != null) {
//			System.out.println(film);
//		} else {
//			System.out.println("no film found");
//		}
//		
//		Actor actor = databaseAccessor.findActorById(143);
//		if (actor != null) {
//			System.out.println(actor);
//		} else {
//			System.out.println("no actor found");
//		}
//		
//		List<Actor> cast = databaseAccessor.findActorsByFilmId(10);
//		System.out.println(cast);
//	}
}