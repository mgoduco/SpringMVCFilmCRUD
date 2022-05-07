package com.skilldistillery.film.ignorefiles;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.film.dao.DatabaseAccessor;
import com.skilldistillery.film.dao.DatabaseAccessorObject;
import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();
	DatabaseAccessorObject dao = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
		app.test();

//		app.launch();
	}

	private void test() {
	System.out.println(	dao.createFilm(addNewFilm()));
	}

	private void launch() throws SQLException {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) throws SQLException {
		boolean keepGoing = true;
		do {
			System.out.println("====================================");
			System.out.println("====  1. Look up a film by id   ====");
			System.out.println("== 2. Look up a film by a keyword ==");
			System.out.println("========== 3. Create Film ==========");
			System.out.println("============= 4. Exit ==============");
			System.out.println("====================================");

			int choice = 0;
			try {
				choice = input.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Invalid input");
				input.nextLine();
				continue;
			}

			switch (choice) {
			case 1:
				lookUpFilmById(input);
				break;
			case 2:
				lookUpFilmBySearch(input);
				break;
			case 3:
				addNewFilm();
				break;
			case 4:
				System.out.println("Goodbye");
				exit();
				break;
			default:
				System.out.println("Invalid input");
				break;
			}
			input.nextLine();
		} while (keepGoing);
	}

	private void lookUpFilmById(Scanner input) throws SQLException {
		System.out.println("Enter a film ID: ");
		Film film = db.findFilmById(input.nextInt());
		try {
			printFilm(film);
		} catch (NullPointerException e) {
			System.out.println("No results try again.");
		}
	}

	private void lookUpFilmBySearch(Scanner input) throws SQLException {
		System.out.println("Enter a search word: ");
		String choice = input.nextLine();
		System.out.println(choice);
		List<Film> films = db.findFilmByKeyword(input.next());
		try {
			for (Film f : films) {
				printFilm(f);
			}
		} catch (NullPointerException e) {
			System.out.println("No results, please try again.");
		}
	}

	private void printFilm(Film film) {
		System.out.println("=====  FILM  =====");
		System.out.println(film.getTitle());
		System.out.println("Released on " + film.getReleaseYear());
		System.out.println(film.getRating() + " Rating");
		System.out.println(film.getDesc());
		System.out.println("Language: " + film.getLangName());
		System.out.println("===== Actors =====");
		for (Actor a : film.getActorList()) {
			System.out.println(a.getFirstName() + " " + a.getLastName());
		}
		System.out.println();
	}

	private Film addNewFilm() {
		System.out.println("Adding new film");
		Film film = new Film();
		film.setTitle("New Film Test");
		film.setDesc("New Film Test desc");
		

		return film;
	}

	private void exit() {
		System.exit(0);
	}

}
