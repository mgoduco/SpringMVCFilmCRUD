package com.skilldistillery.film.dao;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface DatabaseAccessor {

	public Film findFilmById(Integer filmId);

	public Film createFilm(Film film) throws SQLException;

	public List<Film> getFilmByKeyword(String keyword) throws SQLException;

	public List<Actor> findActorsByFilmId(Integer filmId);

	public Actor findActorById(Integer actorId);

	public Film deleteFilm(Film film);

	public Film saveFilm(Film film);

}