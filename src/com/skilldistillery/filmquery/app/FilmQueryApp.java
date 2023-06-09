package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	private DatabaseAccessor databaseAccessor = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
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
				Film filmResult = findFilmById(scanner);
				if (filmResult != null) {
					System.out.println("would you like to view all details of this/these film(s)? 1(Yes) or 2(No)");
					if (getValidInput(scanner, inputRangeStart, inputRangeEnd) == 1) {
						List<Film> idSearchResults = idSearchCopies(filmResult);
						displayFilmsDetails(idSearchResults); 
					}
					break;
				} 
				else {
					System.out.println("There Are No Matches To This ID, Please Try Again.");
					continue;
				}
			case 2:
				System.out.println("What Would You Like to Search?");
				String searchStatement = scanner.nextLine();
				List<Film> searchResults = findFilmBySearch(searchStatement);
				if (!searchResults.isEmpty()) {
					System.out.println("would you like to view all details of this/these film(s)? 1(Yes) or 2(No)");
					if (getValidInput(scanner, inputRangeStart, inputRangeEnd) == 1) {
						searchResults =	getCopyConditions(searchStatement);
						displayFilmsDetails(searchResults);
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

	private Film findFilmById(Scanner scanner) {
		System.out.println("Enter The Id Of The Film You're Searching For ");
		int selection = getIntInput(scanner);
		Film film = databaseAccessor.findFilmById(selection);

		if (film != null) {
			System.out.println(film.getTitle());
		}
		return film;
	}

	private List<Film> findFilmBySearch(String searchStaement) {
		List<Film> films = databaseAccessor.findFilmsByKeyword(searchStaement);
		if (!films.isEmpty()) {
			for (Film film : films) {
				System.out.println("Title : " + film.getTitle());
				System.out.println(" ");
			}
		}
		return films;

	}
	
	private List<Film> getCopyConditions(String searchStatent) {
		List<Film> films = databaseAccessor.getAllInfoOnAllCopiesFilms(searchStatent);		
		return films;
		
	}
	
	private List<Film> idSearchCopies(Film film) {
		List<Film> films = databaseAccessor.findCopiesCondition(film);
		return films;
	}
	
	private void displayFilmsDetails(List<Film> films) {
		for (Film film : films) {
			System.out.println("Title : " + film.getTitle());
			System.out.println("Year : " + film.getReleaseYear());
			System.out.println("Rating : " + film.getRating());
			System.out.println("Description : " + film.getDescription());
			System.out.println("Condition : " + film.getCondition());
			System.out.println("Category : " + film.getCategory());
			System.out.println("Language : " + film.getLanguage());
			System.out.println("Cast : " + film.getCast());
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
}
