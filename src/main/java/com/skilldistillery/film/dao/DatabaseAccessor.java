package com.skilldistillery.film.dao;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface DatabaseAccessor {

	public Film findFilmById(int filmId);

	public void createFilm(Film film) throws SQLException;

	public List<Film> findFilmByKeyword(String keyword);

	public List<Actor> findActorsByFilmId(int filmId);

}