package com.skilldistillery.film.dao;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface DatabaseAccessor {

	public Film findFilmById(int filmId);

	public Film createFilm(Film film) throws SQLException;

	public List<Film> findFilmByKeyword(String keyword) throws SQLException;

	public List<Actor> findActorsByFilmId(int filmId);

	public Actor findActorById(int actorId);

	public Film deleteFilm(Film film);
	
	public Film saveFilm(String title, String description, short release_year, int language_id, int rental_duration,
			double rental_rate, int length, double replacement_cost, String rating, String special_features);

}