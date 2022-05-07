package com.skilldistillery.film.dao;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface FilmDAO {

	public Film getFilmById(int filmId);

	public List<Film> findFilmByKeyword(String keyword);

	public List<Actor> findActorsByFilmId(int filmId);

	public void createFilm(Film film) throws SQLException;

}
